package com.lch;

import java.util.List;

public class All_Data {
    private List<Data> all_input;
    private List<Data> all_Shifter;
    private List<Data> all_Alpha;

    private static All_Data data = new All_Data();
    public static All_Data getData(){
        return data;
    }
}
