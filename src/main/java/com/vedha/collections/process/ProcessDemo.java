package com.vedha.collections.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// ProcessBuilder is a class in Java that is used to create operating system processes.
// Process is a class in Java that is used to execute system commands.
public class ProcessDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println();
        String systemOsName = System.getProperty("os.name");
        System.out.println("OS Name: " + systemOsName);

        String systemHomePath = System.getProperty("user.home");
        System.out.println("Home Path: " + systemHomePath);

        String systemUserName = System.getProperty("user.name");
        System.out.println("User Name: " + systemUserName);

        String systemUserCountry = System.getProperty("user.country");
        System.out.println("User Country: " + systemUserCountry);

        System.out.println();
        String systemName = Inet4Address.getLocalHost().getHostName();
        System.out.println("System Name: " + systemName);

        String systemIP = Inet4Address.getLocalHost().getHostAddress();
        System.out.println("System IP: " + systemIP);

        // Process Builder creating a new process and executing a command
        System.out.println();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "dir");
        Process process1 = processBuilder.start();

        boolean b = process1.waitFor(2, TimeUnit.SECONDS);
        System.out.println("Process Completed: " + b);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
        System.out.println("Output: ");
        reader.lines().forEach(System.out::println);

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getErrorStream()));
        System.out.println("Error: ");
        reader1.lines().forEach(System.out::println);

        int i = process1.exitValue();
        System.out.println("Exit Value: " + i);

        ProcessHandle.Info info = process1.info();
        System.out.println("Info: " + info);

    }
}
