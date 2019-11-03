package com.serch_strategy;

import com.lch.All_Data;
import com.lch.Data;

import javax.swing.*;
import java.util.ArrayList;

public class Sort_Baoli implements Search_Strategy {
    ArrayList<String> sort_result = new ArrayList<String>();

    @Override
    public void doOperation(String search_contents, JTextField jTextField) {
        jTextField.setText("");
        String[] ch = search_contents.split(" ");

        for (Data data : All_Data.getData().all_input) {//循环查找输入内容
            int temp = 0;
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                temp = 0;
                for (int j = 0; j < data.getLine().split(" ").length; j++) {
                    if (ch[i].equals(data.getLine().split(" ")[j]))
                        temp = 1;
                }
                if (temp ==1)
                    sum++;
            }
            if (sum == ch.length)
                jTextField.setText(jTextField.getText()+" "+data.getLine());
        }

    }
}

