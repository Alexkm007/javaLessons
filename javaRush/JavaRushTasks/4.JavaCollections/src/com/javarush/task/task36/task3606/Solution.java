package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {

        File pathToClasses = new File(packageName);
        String className;
        final String finalPathToClasses = pathToClasses.getAbsolutePath() + File.separator; // путь к папке с классами, имя класса в путь не входит

        for (File f : pathToClasses.listFiles()) {
            className = f.getName();

            ClassLoader loader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    try {
                        // Читаем все данные из самого класса
                        byte[] data = Files.readAllBytes(Paths.get(finalPathToClasses + name)); // name это имя.расширение самого
                        // Возвращаем вычитанный класс                                                                           // класса которое подтягивается из функции LoadClass
                        return defineClass(null, data, 0, data.length);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            };

            Class loadedClass = loader.loadClass(className); // передаем сюда только имя.расширение класса а не путь
            if (HiddenClass.class.isAssignableFrom(loadedClass)) {
                hiddenClasses.add(loadedClass);
            }
        }


    }

    public HiddenClass getHiddenClassObjectByKey(String key) {

        for(Class clazz: hiddenClasses){
            if(clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())){
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for(Constructor constructor: constructors){
                        if(constructor.getParameterTypes().length==0){
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

