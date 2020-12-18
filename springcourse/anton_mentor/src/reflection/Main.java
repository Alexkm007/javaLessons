package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        Class classOne = map.getClass();
        Class classTwo = HashMap.class;
        Class classThree = null;
        try {
            classThree = Class.forName("java.util.HashMap");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(classOne);
        System.out.println(classTwo);
        System.out.println(classThree);

        printInfoClass(classOne);
        printModifiers(classOne);
        printAllfields(classOne);
    }

    static void printInfoClass(Class classTest){
        System.out.println(classTest.getSuperclass().getName());
        System.out.println("Интерфейсы класса: ");
        for (Class cl:classTest.getInterfaces()){
            System.out.println("interface: " + cl.getName());
        }

        System.out.println("Открытые свойства класса: ");
        for(Field field:classTest.getFields()){
            System.out.println("field: " + field.getName());
        }

        System.out.println("Методы класса: ");
        for(Method method:classTest.getMethods()){
            System.out.println("method: " + method.getName());
        }

    }

    static void printModifiers(Class classTest){

        int mod = classTest.getModifiers();
        System.out.println(Integer.toBinaryString(mod));
        System.out.println("Public class: " + Modifier.isPublic(mod));
        System.out.println("Private class: " + Modifier.isPrivate(mod));
        System.out.println("Private class: " + Modifier.isPrivate(mod));
    }

    static void printAllfields(Class classTest){
        System.out.println("Все поля класса");
        for(Field field:classTest.getDeclaredFields()){
            System.out.println("field: " + field.getName());
        }
    }

}
