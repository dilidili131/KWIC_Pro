package com.serch_strategy;

import com.lch.All_Data;
import com.lch.Data;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_Half implements Search_Strategy {

    List<Data> newlist = new ArrayList<Data>();

    @Override
    public void doOperation(String search_contents, JTextField jTextField) {
        jTextField.setText("");
        String[] ch = search_contents.split(" ");

        for (Data data : All_Data.getData().all_input) {
            ArrayList<String> list = new ArrayList<String>();

            for (int i=0;i<data.getLine().split(" ").length;i++){
                list.add(data.getLine().split(" ")[i]);
            }
            Collections.sort(list);
            String str = "";
            for (int i=0;i<list.size();i++){
                if (str.isEmpty())
                    str = str+list.get(i);
                else
                    str = str + " " + list.get(i);
            }
            newlist.add(new Data(data.getLine_row(),str));
        }
        for (int k =0;k<newlist.size();k++) {
            int temp = 0;
            int sum = 0;
            for (int i=0;i<ch.length;i++){
                //System.out.println(i+ch[i]);
                temp = 0;
                int left = 0;
                int right = newlist.get(k).getLine().split(" ").length-1;
                int mid;
                while (left <= right){
                    mid = (left + right)/2;
                    if (ch[i].equals(newlist.get(k).getLine().split(" ")[mid])){
                        temp = 1;
                        break;
                        //System.out.println("temp: "+temp);

                    }else if (ch[i].compareTo(newlist.get(k).getLine().split(" ")[mid])<0){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                if (temp == 1)
                    sum++;
            }
            if (sum == ch.length)
                jTextField.setText(jTextField.getText()+" "+All_Data.getData().all_input.get(k).getLine());
        }

    }
}
