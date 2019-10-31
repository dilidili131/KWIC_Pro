package com.lch;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAlphabetizer{
    private List<String> lines;

    public MyAlphabetizer() {
    }

    public MyAlphabetizer(List<String> lines) {
        this.lines = alfabetize(lines);
    }

    int comp(char ch1,char ch2){
        //System.out.println("ch1,ch2:" +ch1 + "，"+ch2);
        int num1 = 0,num2 = 0;
        switch (ch1){
            case 'a': num1 = 0;break;case 'A': num1 = 1;break;
            case 'b': num1 = 2;break;case 'B': num1 = 3;break;
            case 'c': num1 = 4;break;case 'C': num1 = 5;break;
            case 'd': num1 = 6;break;case 'D': num1 = 7;break;
            case 'e': num1 = 8;break;case 'E': num1 = 9;break;
            case 'f': num1 = 10;break;case 'F': num1 = 11;break;
            case 'g': num1 = 12;break;case 'G': num1 = 13;break;
            case 'h': num1 = 14;break;case 'H': num1 = 15;break;
            case 'i': num1 = 16;break;case 'I': num1 = 17;break;
            case 'j': num1 = 18;break;case 'J': num1 = 19;break;
            case 'k': num1 = 20;break;case 'K': num1 = 21;break;
            case 'l': num1 = 22;break;case 'L': num1 = 23;break;
            case 'm': num1 = 24;break;case 'M': num1 = 25;break;
            case 'n': num1 = 26;break;case 'N': num1 = 27;break;
            case 'o': num1 = 28;break;case 'O': num1 = 29;break;
            case 'p': num1 = 30;break;case 'P': num1 = 31;break;
            case 'q': num1 = 32;break;case 'Q': num1 = 33;break;
            case 'r': num1 = 34;break;case 'R': num1 = 35;break;
            case 's': num1 = 36;break;case 'S': num1 = 37;break;
            case 't': num1 = 38;break;case 'T': num1 = 39;break;
            case 'u': num1 = 40;break;case 'U': num1 = 41;break;
            case 'v': num1 = 42;break;case 'V': num1 = 43;break;
            case 'w': num1 = 44;break;case 'W': num1 = 45;break;
            case 'x': num1 = 46;break;case 'X': num1 = 47;break;
            case 'y': num1 = 48;break;case 'Y': num1 = 49;break;
            case 'z': num1 = 50;break;case 'Z': num1 = 51;break;
        }
        switch (ch2){
            case 'a': num2 = 0;break;case 'A': num2 = 1;break;
            case 'b': num2 = 2;break;case 'B': num2 = 3;break;
            case 'c': num2 = 4;break;case 'C': num2 = 5;break;
            case 'd': num2 = 6;break;case 'D': num2 = 7;break;
            case 'e': num2 = 8;break;case 'E': num2 = 9;break;
            case 'f': num2 = 10;break;case 'F': num2 = 11;break;
            case 'g': num2 = 12;break;case 'G': num2 = 13;break;
            case 'h': num2 = 14;break;case 'H': num2 = 15;break;
            case 'i': num2 = 16;break;case 'I': num2 = 17;break;
            case 'j': num2 = 18;break;case 'J': num2 = 19;break;
            case 'k': num2 = 20;break;case 'K': num2 = 21;break;
            case 'l': num2 = 22;break;case 'L': num2 = 23;break;
            case 'm': num2 = 24;break;case 'M': num2 = 25;break;
            case 'n': num2 = 26;break;case 'N': num2 = 27;break;
            case 'o': num2 = 28;break;case 'O': num2 = 29;break;
            case 'p': num2 = 30;break;case 'P': num2 = 31;break;
            case 'q': num2 = 32;break;case 'Q': num2 = 33;break;
            case 'r': num2 = 34;break;case 'R': num2 = 35;break;
            case 's': num2 = 36;break;case 'S': num2 = 37;break;
            case 't': num2 = 38;break;case 'T': num2 = 39;break;
            case 'u': num2 = 40;break;case 'U': num2 = 41;break;
            case 'v': num2 = 42;break;case 'V': num2 = 43;break;
            case 'w': num2 = 44;break;case 'W': num2 = 45;break;
            case 'x': num2 = 46;break;case 'X': num2 = 47;break;
            case 'y': num2 = 48;break;case 'Y': num2 = 49;break;
            case 'z': num2 = 50;break;case 'Z': num2 = 51;break;
        }
        return (num1 - num2);
    }

    private List<String> alfabetize(List<String> lines){
        Collections.sort(lines, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1==null&&o2==null){
                    throw new NullPointerException();
                }
                int num = 0;
                while(o1.charAt(num)==o2.charAt(num)){
                    num++;
                }
                int compareValue=0;
                char o1c=o1.charAt(num);
                char o2c=o2.charAt(num);
                //compareValue=o1c-o2c;
                //System.out.println("o1c,o2c:" +o1c + "，" +o2c);
                int temp = comp(o1c,o2c);
                return temp;
            }
        });
        return lines;
    }

    public List<String> getLines() {
        return lines;
    }
}
