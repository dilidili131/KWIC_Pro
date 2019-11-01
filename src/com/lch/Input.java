package com.lch;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Input{
    public Input(String input){
        //输入部分
        String[] lines = input.split("\n");
        List<Data> all_input = new ArrayList<>();
        for (int i=0;i<lines.length;i++){
            Data data = new Data(i+1,lines[i]);
            all_input.add(data);
        }
        All_Data.getData().all_input = all_input;
    }
}
