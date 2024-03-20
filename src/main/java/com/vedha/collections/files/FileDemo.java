package com.vedha.collections.files;

import java.io.File; // io - input output
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files; // nio - new input output
import java.util.Arrays;
import java.util.Objects;

public class FileDemo {

    public static void main(String[] args) {

        File file = new File("D:\\NewDir");
        System.out.println("file path: " + file.toPath()); // returns path of file
        System.out.println("file name: " + file.getName()); // returns name of file or directory
        System.out.println("file exist: " + file.exists()); // true if file or directory exists
        System.out.println("file isDir: " + file.isDirectory()); // true if directory exists
        System.out.println("file isFile: " + file.isFile()); // true if file exists
        System.out.println("file MkDir: " + file.mkdir()); // create single directory

        System.out.println("file exist: " + Files.exists(file.toPath()));

        File file2 = new File("D:\\NewDir\\NewDir2\\NewDir3");
        System.out.println("file path: " + file2.toPath());
        System.out.println("file exist: " + file2.exists());
        System.out.println("file isDir: " + file2.isDirectory());
        System.out.println("file isFile: " + file2.isFile());
        System.out.println("file MkDirs: " + file2.mkdirs()); // create multiple directories

        File file3 = new File("D:\\NewDir\\NewDir2\\NewDir3\\NewFile.txt");
        System.out.println("file path: " + file3.toPath()); // returns path of file
        System.out.println("file name: " + file3.getName()); // returns name of file or directory
        System.out.println("file exist: " + file3.exists()); // true if file or directory exists
        System.out.println("file isDir: " + file3.isDirectory()); // true if directory exists
        System.out.println("file isFile: " + file3.isFile()); // true if file exists

        try {
            System.out.println("file create: " + file3.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("file canRead: " + file3.canRead()); // true if file can be read
        System.out.println("file canWrite: " + file3.canWrite()); // true if file can be written
        System.out.println("file canExec: " + file3.canExecute()); // true if file can be executed
        System.out.println("file delete: " + file3.delete()); // delete file

        /*
         Unit	Shortened	Capacity
         Bit	    b	    1 or 0 (on or off)
         Byte	    B	    8 bits
         Kilobyte	KB	    1024 bytes
         Megabyte	MB	    1024 kilobytes
         Gigabyte	GB	    1024 megabytes
         Terabyte	TB	    1024 gigabytes
         Petabyte	PB	    1024 terabytes
         Exabyte	EB	    1024 petabytes
         */

        System.out.println("gb: " + 1024 * 1024 * 1024); // returns 1 GB in bytes
        System.out.println("disk total space in bytes: " + file.getTotalSpace()); // returns total space in bytes of file system drive
        System.out.println("disk total space in gb: " + BigInteger.valueOf(file.getFreeSpace()).divide(BigInteger.valueOf(1024 * 1024 * 1024))); // returns free space in GB

        File file4 = new File("D:\\Devops\\sample-spring-microservices-kubernetes");
        System.out.println(Arrays.toString(file4.list())); // returns list of files and directories as string array
        System.out.println(Arrays.toString(file4.list((dir, name) -> name.endsWith(".json") || name.endsWith(".yaml")))); // returns list of files with .json, .yaml extension

        System.out.println(Arrays.toString(file4.listFiles())); // returns list of files and directories as file array
        System.out.println(Arrays.stream(Objects.requireNonNull(file4.listFiles())).filter(File::isDirectory).toList()); // returns list of dir
        System.out.println(Arrays.stream(Objects.requireNonNull(file4.listFiles())).filter(files -> files.isDirectory() && files.getName().startsWith(".")).toList()); // returns list of dir with . prefix

    }
}
