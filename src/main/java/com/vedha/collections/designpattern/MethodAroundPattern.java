package com.vedha.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

class FileReading {

    private Path path;

    private BufferedReader bufferedReader;

    private FileReading() {
    }

    public static List<String> process(Consumer<FileReading> block) throws IOException {

        FileReading fileReading = new FileReading();
        try {

            block.accept(fileReading);
            fileReading.bufferedReader = Files.newBufferedReader(fileReading.path);
            return fileReading.getAllLines();

        } catch (Exception e) {

            throw new RuntimeException(e);
        } finally {

            System.out.println("Closing Called!!");
            fileReading.bufferedReader.close();
        }

    }

    public void path(Path path) {

        this.path = path;
    }

    private List<String> getAllLines() {

        return bufferedReader.lines().toList();
    }
}

public class MethodAroundPattern {

    public static void main(String[] args) throws IOException {

        FileReading.process(fileReading -> fileReading.path(Path.of("D:\\Viki\\test.txt")))
                .forEach(System.out::println);

    }
}
