package com.vedha.collections.files;

import java.io.*;

/**
 * FileBinaryReadingWriting
 * Stream is used for reading and writing binary data
 * FileInputStream and FileOutputStream are used for reading and writing binary data
 * example image, audio, video, pdf, doc, xls, etc.
 */
public class FileBinaryReadingWritingDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\NewDir\\NewDir2\\NewDir3\\Vedha.png");
        System.out.println("File exists: " + file.exists());
        System.out.println("File is file: " + file.isFile());
        System.out.println("File is directory: " + file.isDirectory());
        System.out.println("file can execute: " + file.canExecute());
        System.out.println("file can read: " + file.canRead());

        // File Input Stream
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes(); // read all bytes from file png
//        System.out.println(Arrays.toString(bytes));
        fileInputStream.close();

        // File Output Stream
        File file2 = new File("D:\\NewDir\\NewDir2\\NewDir3\\Vedha2.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(bytes); // write all bytes to file2 png
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
