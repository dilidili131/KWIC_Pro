package com.observer;

import com.lch.All_Data;
import com.lch.Data;

import javax.swing.*;
import java.util.List;

public class TextArea2_Observer implements Observer {
    public TextArea2_Observer(List<Observer> observers){
        observers.add(this);
    }
    @Override
    public void update(JTextArea textArea_2,JTextPane textPane_3) {
//        System.out.println("我是TextArea2观察者");
        textArea_2.setText("");
        for (Data data:All_Data.getData().all_Alpha) {
            if (textArea_2.getText().isEmpty()) {
                textArea_2.setText(data.getLine());
            } else {
                textArea_2.setText(textArea_2.getText() + "\n" + data.getLine());
            }
        }
    }
}
