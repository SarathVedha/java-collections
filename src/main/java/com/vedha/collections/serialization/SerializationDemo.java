package com.vedha.collections.serialization;

import java.io.*;
import java.util.Objects;

// static fields are not serialized because they are not part of the state of the object, they are part of the class.
public class SerializationDemo implements Serializable {

    static int staticField = 10;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerializationDemo that)) return false;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "SerializationDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        // Serialization is a mechanism of converting the state of an object into a byte stream.
        // Deserialization is the reverse process of serialization. It is the mechanism of reconstructing the object from the serialized state.
        SerializationDemo serializationDemo = new SerializationDemo();
        serializationDemo.setName("Vedha");
        serializationDemo.setAge(25);

        System.out.println("serializationDemo: " + serializationDemo);

        // throws NotSerializableException if SerializationDemo class does not implement Serializable interface
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\sarat\\Downloads\\serializationDemo.txt"))) {

            objectOutputStream.writeObject(serializationDemo);
            objectOutputStream.flush();
            objectOutputStream.close();

            System.out.println("Serialization done");
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\sarat\\Downloads\\serializationDemo.txt"))) {

            // SerializationDemo deserialization = (SerializationDemo) objectInputStream.readObject();
            Object seObject = objectInputStream.readObject();
            if (seObject instanceof SerializationDemo deserialization) {
                System.out.println("deserialization: " + deserialization);
            }
            objectInputStream.close();

            System.out.println("Deserialization done");
        }catch (IOException e) {
            System.err.println("IOException: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e);
        }
    }
}
