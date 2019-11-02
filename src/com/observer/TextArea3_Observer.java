package com.observer;

import com.lch.All_Data;
import com.lch.Data;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util.List;

public class TextArea3_Observer extends Observer {
    public TextArea3_Observer(List<Observer> observers){
        observers.add(this);
    }

    @Override
    public void update(JTextArea textArea_2, JTextPane textPane_3) {
        System.out.println("我是TextArea3观察者");
        textPane_3.setText("");
        for (Data data:All_Data.getData().all_Alpha) {
            Style def = textPane_3.getStyledDocument().addStyle(null,null);
            StyleConstants.setFontFamily(def,"Microsoft YaHei UI");
            StyleConstants.setFontSize(def,18);
            StyleConstants.setBold(def,true);
            Style normal = textPane_3.addStyle("normal",def);
            Style s1 = textPane_3.addStyle("blue",normal);
            StyleConstants.setForeground(s1, Color.BLUE);
            Style s2 = textPane_3.addStyle("red",normal);
            StyleConstants.setForeground(s2, Color.RED);
            Style s3 = textPane_3.addStyle("yellow",normal);
            StyleConstants.setForeground(s3, Color.YELLOW);
            Style s4 = textPane_3.addStyle("pink",normal);
            StyleConstants.setForeground(s4, Color.PINK);
            textPane_3.setParagraphAttributes(normal,true);
            switch(data.getLine_row()){

                case 1:
                    if(textPane_3.getText().isEmpty()){
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    data.getLine(),textPane_3.getStyle("blue"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane_3.getStyle("blue"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    if(textPane_3.getText().isEmpty()){
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    data.getLine(),textPane_3.getStyle("red"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane_3.getStyle("red"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    if(textPane_3.getText().isEmpty()){
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    data.getLine(),textPane_3.getStyle("yellow"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane_3.getStyle("yellow"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    if(textPane_3.getText().isEmpty()){
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    data.getLine(),textPane_3.getStyle("pink"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane_3.getDocument().insertString(textPane_3.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane_3.getStyle("pink"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }


        }
    }
}
