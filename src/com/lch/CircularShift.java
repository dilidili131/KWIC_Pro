package com.lch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CircularShift{

    public CircularShift(List<Data> all_input) {
        //循环移位部分
        List<Data> all_shifter = new ArrayList<>();
        for(int i = 0;i < all_input.size();i++){//行数
            Data input_line = all_input.get(i);
            String[] one_line = input_line.line.split(" ");//以空格分隔存入数组
            Integer line_num = input_line.line_row;

            for(int j = 0;j < one_line.length;j++){
                String new_line = "";
                for(int k=j+1;k<one_line.length;k++){ //从第二个单词开始
                    new_line = new_line +" "+ one_line[k];
                }
                for(int k= 0;k<j+1;k++){
                    new_line = new_line +" "+one_line[k];
                }
                all_shifter.add(new Data(line_num,new_line));
            }

        }
        All_Data.getData().all_Shifter = all_shifter;
    }

}
