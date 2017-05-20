package ua.kpi.training.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Anya on 20.05.2017.
 */
public class Reflection {
    Class clazz;
    Object obj;

    public Reflection(Object obj) {
        clazz = obj.getClass();
        this.obj = obj;
    }

    public void getConstructors(String ConstructorAnnotation) {

        Constructor[] constructors = clazz.getConstructors();
        System.out.println(ConstructorAnnotation + clazz.getSimpleName());
        for (Constructor constructor : constructors) {
            String temp = constructor.getName();
            Class[] paramTypes = constructor.getParameterTypes();
            int i = 1;
            System.out.println(temp);
            for (Class paramType : paramTypes) {
                System.out.print(i + " " + paramType.getName() + " ");
                i++;
            }
            System.out.println();
        }
    }

    public void getModificator(String modificatorAnnotation) {
        int mods = clazz.getModifiers();
        System.out.println(modificatorAnnotation + clazz.getSimpleName());
        if (Modifier.isPublic(mods)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("final");
        }
    }

    public void getMethods(String methodAnnotation) {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methodAnnotation + clazz.getSimpleName());
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length != 0) {
                System.out.println("Аннотации метода: ");
                for (Annotation annotation : annotations)
                    System.out.print("@" + annotation.annotationType().getSimpleName() + " ");
                System.out.println();
            }
            System.out.println("Имя: " + method.getName() + " Возвращаемый тип: " + method.getReturnType().getName());
            Class[] paramTypes = method.getParameterTypes();
            if (paramTypes.length != 0) {
                System.out.println("Типы параметров: ");
                for (Class paramType : paramTypes)
                    System.out.print(" " + paramType.getName());
                System.out.println();
            }
        }

    }

    public void getPackageAndClassName(String packageAnnotation, String classAnnotation, String supetClassAnnotation) {
        System.out.println(packageAnnotation + clazz.getName());
        System.out.println(classAnnotation + clazz.getSimpleName());
        System.out.println(supetClassAnnotation + clazz.getSuperclass());

    }

    public void getFields(String fieldsAnnotation) {
        System.out.println(fieldsAnnotation+clazz.getSimpleName());
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            Class fieldType = field.getType();
            int mods = field.getModifiers();

            System.out.print("Имя: " + field.getName() + "Тип: " + fieldType.getSimpleName() + " Модификатор: ");
            if (Modifier.isPublic(mods)) {
                System.out.print(" public");
            }
            if (Modifier.isPrivate(mods)) {
                System.out.print(" private");
            }
            if (Modifier.isStatic(mods)) {
                System.out.print(" statiс");
            }
            System.out.println();
        }
    }

    public void getAnnotations(String annotation) {
        System.out.println(annotation+clazz.getSimpleName());
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation1 : annotations) {
            System.out.print("@" + annotation1.getClass().getSimpleName() + " ");
        }
    }

    public void getInterfaces(String interfacesAnnotation) {
        System.out.println(interfacesAnnotation+clazz.getSimpleName());
        Class[] interfaces = clazz.getInterfaces();
        for (Class cInterface : interfaces) {
            System.out.println(cInterface.getName());

        }
    }
}
