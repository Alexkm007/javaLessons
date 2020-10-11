package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes){

            if(Modifier.isPrivate(c.getModifiers()))
                if(Modifier.isStatic(c.getModifiers()))
                {
                    if(List.class.isAssignableFrom(c))
                    {
                        try{
                            Constructor constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List) constructor.newInstance();
                            list.get(0);
                        }catch (IndexOutOfBoundsException e){
                            // вернуть класс
                            return c;
                        } catch (NoSuchMethodException e) {
                            //e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            //e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }

                }
        }
        return null;
    }
}
