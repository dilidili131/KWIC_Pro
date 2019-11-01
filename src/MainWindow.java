import com.lch.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainWindow{

    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button2;
    private JButton button3;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;

    void kwic(){
        Input input = new Input(textArea1.getText());
        CircularShift circularShift = new CircularShift(All_Data.getData().all_input);
        Alphabetizer alphabetizer = new Alphabetizer(All_Data.getData().all_Shifter);

        System.out.println("排序后输出");
        for (Data data:All_Data.getData().all_Alpha
             ) {
            System.out.println(data.getLine());
        }
    }

    void output(){
        for (Data data:All_Data.getData().all_Alpha
             ) {
            if(textArea2.getText().isEmpty()){
                textArea2.setText(data.getLine_row() + " " + data.getLine());
            }
            else{
                textArea2.setText(textArea2.getText()+ "\n"+ data.getLine_row() + " " + data.getLine());
            }
            if(textArea3.getText().isEmpty()){
                textArea3.setText(data.getLine_row() + " " + data.getLine());

            }
            else{
                textArea3.setText(textArea3.getText()+ "\n"+ data.getLine_row() + " " + data.getLine());
            }

        }
    }

    //Todo
    void setColor(){
        String[] ch = textArea3.getText().split("\n");

    }

    public MainWindow(){
        //button1触发函数
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("textpanel1:");
                System.out.println(textArea1.getText());
                textArea2.setText("");
                textArea3.setText("");
                //进入kwic排序
                kwic();
                //读取文件输出
                output();
                //设置textArea3颜色
                //Todo
            }
        });

        textArea2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("charu");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("sanchu");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("genggai");
            }
        });
        //监控textArea2内容
//        textArea2.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                System.out.println("text1插入");
//                textArea3.setText(textArea2.getText());
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                System.out.println("text1删除");
//                textArea3.setText(textArea2.getText());
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                System.out.println("text1改变");
//                textArea3.setText(textArea2.getText());
//            }
//        });
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        MainWindow mm = new MainWindow();

    }

}
