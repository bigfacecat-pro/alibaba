package learning.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class getclass {
    public static void main(String[] args) {
        try {
            //Class clazz=Class.forName("java.lang.String");
            Class clazz=Class.forName("learning.blockingQueue.Consumer");
            Method[] method=clazz.getDeclaredMethods();
            for(Method m:method){
                System.out.println(m.toString());
            }
            System.out.println("=============");
            Field[] field=clazz.getDeclaredFields();
            for(Field f:field)
                System.out.println(f.toString());
            System.out.println("=============");
            Constructor[] constructors=clazz.getConstructors();
            for(Constructor c:constructors)
                System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
