package com.vedha.collections.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * FileBufferedBinaryReadingWritingDemo
 * BufferedInputStream and BufferedOutputStream are used to read and write binary data from and to the file.
 * it is faster than FileInputStream and FileOutputStream
 * example image, audio, video, pdf, doc, xls, etc.
 */
public class FileBufferedBinaryReadingWritingDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\NewDir\\NewDir2\\NewDir3\\Vedha.png");
        System.out.println("file exists: " + file.exists());

        FileInputStream fileInputStream = new FileInputStream(file);
        // BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = bufferedInputStream.readAllBytes();
//        System.out.println(Arrays.toString(bytes));
        bufferedInputStream.close();

        File file2 = new File("D:\\NewDir\\NewDir2\\NewDir3\\Vedha2.png");
        if (file2.exists()) System.out.println("file deleted: " + file2.delete());

        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        // BufferedOutputStream
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

    }
}
