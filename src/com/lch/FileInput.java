package com.lch;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInput{
    private String fName;

    public FileInput(String fileName) throws FileNotFoundException {
        fName =  fileName;
    }

    public List<String> readAll() throws IOException {
        return Files.readAllLines(Paths.get(fName));
    }
}
