package com.lch;

import java.util.List;

public class All_Data {
    public List<Data> all_input;
    public List<Data> all_Shifter;
    public List<Data> all_Alpha;

    private All_Data() {
    }

    private static All_Data data = new All_Data();
    public static All_Data getData(){
        return data;
    }
}
