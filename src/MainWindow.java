import com.lch.Main;
import com.lch.MyCharacters;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainWindow{

    private JPanel panel1;
    private JButton button1;
    private JTextArea textArea3;
    private JTextArea textArea2;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button2;
    private JButton button3;

    void kwic(){
        Main m = new Main();
        try {
            m.lch();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    void input(){
        File f = new File("input.txt");
        try {
            System.out.println("进入");
            PrintWriter pw = new PrintWriter(f);
            pw.write(textArea1.getText());
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    void output(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                textArea2.setText(textArea2.getText() + "\n" + s);
                textArea3.setText(textArea3.getText() + "\n" + s);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public MainWindow(){
        //button1触发函数
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("点我");
//                textArea2.setText("排序后输出：");
//                textArea3.setText("颜色区别输出：");
                input();
                //进入kwic排序
                kwic();
                //读取文件输出
                output();

                //System.out.println(textArea2.getText());
            }
        });

        //监控textArea2内容
        textArea2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("text1插入");
                textArea3.setText(textArea2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("text1删除");
                textArea3.setText(textArea2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("text1改变");
                textArea3.setText(textArea2.getText());
            }
        });
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
