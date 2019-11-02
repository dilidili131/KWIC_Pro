import com.lch.*;
import com.observer.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainWindow{

    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button2;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextPane textPane1;
    private static java.util.List<Observer> observers = new ArrayList<Observer>();

    public void modify2(){   //将修改保存给all_alpha
        System.out.println("将修改保存给all_alpha");

        String[] textArea2_lines = textArea2.getText().split("\n");
        java.util.List<Data> all_Alpha = new ArrayList<>();
        if(All_Data.getData().all_Alpha.size()==textArea2_lines.length){
            for (int i=0;i<All_Data.getData().all_Alpha.size();i++){
                all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i).getLine_row(),textArea2_lines[i]));
            }
        }else{
            //Todo
            for (int i=0;i<textArea2_lines.length;i++){
                if (All_Data.getData().all_Alpha.get(i).getLine().equals(textArea2_lines[i])){
                    all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i).getLine_row(),textArea2_lines[i]));
                }else {
                    all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i+1).getLine_row(),textArea2_lines[i]));
                }
            }
        }
        All_Data.getData().all_Alpha = all_Alpha;

//        for (Data data:All_Data.getData().all_Alpha
//             ) {
//            System.out.println(data.getLine_row()+"     "+data.getLine());
//        }
    }
    public void modify3(){
        System.out.println("将修改保存给all_alpha");

        String[] textArea3_lines = textPane1.getText().split("\n");
        java.util.List<Data> all_Alpha = new ArrayList<>();
        if(All_Data.getData().all_Alpha.size()==textArea3_lines.length){
            for (int i=0;i<All_Data.getData().all_Alpha.size();i++){
                all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i).getLine_row(),textArea3_lines[i]));
            }
        }else{
            //Todo
            for (int i=0;i<textArea3_lines.length;i++){
                if (All_Data.getData().all_Alpha.get(i).getLine().equals(textArea3_lines[i])){
                    all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i).getLine_row(),textArea3_lines[i]));
                }else {
                    all_Alpha.add(new Data(All_Data.getData().all_Alpha.get(i+1).getLine_row(),textArea3_lines[i]));
                }
            }
        }
        All_Data.getData().all_Alpha = all_Alpha;
    }
    //Todo
    public void notifyAllObservers(){//通知所有观察者
        for (Observer ob:observers){
            ob.update(textArea2,textPane1);
        }
    }

    public MainWindow(){
        new TextArea2_Observer(observers);
        new TextArea3_Observer(observers);
        //button1触发函数
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText("");
                textPane1.setText("");
                //进入kwic排序
                kwic();
                //读取文件输出
                output();
            }
        });
        //被观察者触发函数通知观察者
        textArea2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                modify2();
                notifyAllObservers();
            }
        });
        textPane1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("textPanel修改keyRealease");
                modify3();
                notifyAllObservers();
            }
        });

    }

    void kwic(){
        Input input = new Input(textArea1.getText());
        CircularShift circularShift = new CircularShift(All_Data.getData().all_input);
        Alphabetizer alphabetizer = new Alphabetizer(All_Data.getData().all_Shifter);

    }
    void output(){
        for (Data data:All_Data.getData().all_Alpha) {
            if(textArea2.getText().isEmpty()){
                textArea2.setText(data.getLine());
            }
            else{
                textArea2.setText(textArea2.getText()+ "\n"+data.getLine());
            }
            Style def = textPane1.getStyledDocument().addStyle(null,null);
            StyleConstants.setFontFamily(def,"Microsoft YaHei UI");
            StyleConstants.setFontSize(def,18);
            StyleConstants.setBold(def,true);
            Style normal = textPane1.addStyle("normal",def);
            Style s1 = textPane1.addStyle("blue",normal);
            StyleConstants.setForeground(s1, Color.BLUE);
            Style s2 = textPane1.addStyle("red",normal);
            StyleConstants.setForeground(s2, Color.RED);
            Style s3 = textPane1.addStyle("yellow",normal);
            StyleConstants.setForeground(s3, Color.YELLOW);
            Style s4 = textPane1.addStyle("pink",normal);
            StyleConstants.setForeground(s4, Color.PINK);
            textPane1.setParagraphAttributes(normal,true);
            switch(data.getLine_row()){

                case 1:
                    if(textPane1.getText().isEmpty()){
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    data.getLine(),textPane1.getStyle("blue"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane1.getStyle("blue"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    if(textPane1.getText().isEmpty()){
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    data.getLine(),textPane1.getStyle("red"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane1.getStyle("red"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    if(textPane1.getText().isEmpty()){
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    data.getLine(),textPane1.getStyle("yellow"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane1.getStyle("yellow"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4:
                    if(textPane1.getText().isEmpty()){
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    data.getLine(),textPane1.getStyle("pink"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            textPane1.getDocument().insertString(textPane1.getDocument().getLength(),
                                    "\n"+data.getLine(),textPane1.getStyle("pink"));
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }


        }
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
