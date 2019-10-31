package com.lch;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileOutput{

    private PrintWriter out;

    public FileOutput(String filename) throws FileNotFoundException {
        out = new PrintWriter(filename);
    }

    public void writeLines(List<String> lines) {
        lines.forEach(out::println);
    }

    public void close() {
        out.close();
    }
}
