package com.lch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyShifter{
    private List<String> lines;

    public MyShifter(List<String> lines) {
        this.lines = circularShift(lines);
    }

    public MyShifter() {
        this.lines = new LinkedList<>();
    }

    //循环移位，逐一放在最前面
    private List<String> circularShift(List<String> lines){
        List<String> result = new LinkedList<>();
        for (String line: lines) {
            List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
            int lastIndex = words.size() - 1;
            for (int i = 0; i < words.size() ; ++i) {
                words.add(0,words.remove(lastIndex));
                result.add(arrToString(words));
            }
        }
        return result;
    }

    private String arrToString(List<String> arr){
        StringBuilder builder = new StringBuilder();
        for (String node: arr) {
            builder.append(node);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public List<String> getShiftedLines() {
        return lines;
    }
}
