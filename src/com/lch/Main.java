package com.lch;
import java.io.IOException;

public class Main {
    public void lch() throws IOException {
        System.out.println("main进入");
        FileInput in = new FileInput("input.txt");
        MyCharacters characters = new MyCharacters(in.readAll());
        MyShifter shifter = new MyShifter(characters.getLines());
        MyAlphabetizer alphabetizer = new MyAlphabetizer(shifter.getShiftedLines());
        FileOutput output = new FileOutput("output.txt");
        output.writeLines(alphabetizer.getLines());
        output.close();

    }
}

