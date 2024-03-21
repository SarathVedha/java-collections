package com.vedha.collections.files;

import java.io.*;
import java.util.Arrays;

/**
 * FileBufferedReadingWritingDemo
 * Buffered is the best way to read and write the file
 * Buffered is used to read and write the file line by line
 * BufferedWriter for writing the file and BufferedReader for reading the file line by line
 * reader and writer - example text file, csv file, etc.
 */
public class FileBufferedReadingWritingDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\NewDir\\NewDir2\\NewDir3\\NewFile.txt");
        if (file.exists()) System.out.println("file deleted: " + file.delete());
        System.out.println("file created: " + file.createNewFile());
        FileWriter fileWriter = new FileWriter(file); // file writer child class of writer class
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Hello Worlds, Hello People"); // Writing string
        bufferedWriter.newLine(); // Writing new line
        bufferedWriter.write(98); // Writing ASCII value of character
        bufferedWriter.flush(); // Flushes the stream
        bufferedWriter.close(); // Closes the stream

        System.out.println("File written successfully");
        FileReader fileReader = new FileReader(file); // file reader child class of reader class
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        System.out.println((char) bufferedReader.read()); // Reads the character by character
        String readLine = "";
        int count = 0;
        while ((readLine = bufferedReader.readLine()) != null) { // Reads line by line

            System.out.println("line:" + ++count);
            System.out.println(readLine);
            System.out.println(Arrays.toString(readLine.split(","))); // Split the string by comma
        }


    }
}
