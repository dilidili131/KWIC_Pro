package com.lch;
import java.util.List;

public class MyCharacters{
    private List<String> lines;

    public MyCharacters(List<String> lines) {
        this.lines = lines;
    }

    public MyCharacters() {
    }


    //TODO 貌似没用

    public void setChar(List<String> characters) {
        lines = characters;
    }


    public List<String> getLines() {
        return lines;
    }
}
