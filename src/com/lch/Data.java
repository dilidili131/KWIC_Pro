package com.lch;

public class Data {
    String line;//内容
    Integer line_row;//行号

    public Integer getLine_row() {
        return line_row;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setLine_row(Integer line_row) {
        this.line_row = line_row;
    }
}
