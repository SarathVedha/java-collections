package com.vedha.collections.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * FileReadingWritingDemo
 * Reader and Writer is used for text data. example text file, csv file, etc.
 * InputStream is used for reading or writing data from or to a file.
 * InputStream is used for binary data. example image, audio, video, pdf, doc, xls, etc.
 */
public class FileReadingWritingDemo {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\NewDir\\NewDir2\\NewDir3\\NewFile.txt");
        boolean newFile = file.createNewFile();
        System.out.println("file created: " + newFile);

        // Writing to file character by character
        FileWriter fileWriter = new FileWriter(file);
        System.out.println(Arrays.toString("b".getBytes(StandardCharsets.UTF_8)));
        fileWriter.write("Hello World"); // Writing string
        fileWriter.write("\n"); // Writing new line
        fileWriter.write(98); // Writing ASCII value of character
        fileWriter.flush(); // Flushes the stream
        fileWriter.close(); // Closes the stream

        // Reading from file character by character
        FileReader fileReader = new FileReader(file);
        int read = fileReader.read();// Reads single character
        System.out.println("read: " + read); // ASCII value of character
        System.out.println("read: " + (char) read); // Type casting int to char

        // Will read the file till the end -1 is returned if no data is available
        while (read != -1) {

            System.out.print((char) read); // Type casting int to char
            read = fileReader.read();
        }

    }
}

