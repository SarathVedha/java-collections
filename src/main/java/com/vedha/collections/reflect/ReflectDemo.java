package com.vedha.collections.reflect;

import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class ReflectDemo {

    private String name;

    private int age;

    public ReflectDemo() {
        System.out.println("Default constructor");
    }

    public ReflectDemo(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor");
    }

    public void display() {
        System.out.println("Name: " + name + " Age: " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        Class<?> aClass = Class.forName("com.vedha.collections.reflect.ReflectDemo");
        System.out.println(aClass.getName());

        // Get the class object
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        System.out.println(reflectDemoClass.getName());

        // Get the class object using the object
        Class<?>[] declaredClasses = reflectDemoClass.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println(declaredClass);
        }

        System.out.println();
        // Get all the constructors of the class
        Constructor<?>[] declaredConstructors = reflectDemoClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        System.out.println();
        // Get all the fields of the class
        Field[] declaredFields = reflectDemoClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
            System.out.println(field.getType() + " " + field.getName());
        }

        System.out.println();
        Annotation[] declaredAnnotations = reflectDemoClass.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }

        System.out.println();
        Method[] declaredMethods = reflectDemoClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println();
        // Invoking the default constructor using reflection
        Method display = reflectDemoClass.getMethod("display");
        display.invoke(new ReflectDemo());

        System.out.println();
        // Invoking the parameterized constructor and display method using reflection
        Method display2 = reflectDemoClass.getMethod("display");
        display2.invoke(new ReflectDemo("Vedha", 22));
    }
}
