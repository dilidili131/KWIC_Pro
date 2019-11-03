package com.serch_strategy;

import javax.swing.*;
import java.util.ArrayList;

public class Context {
    private Search_Strategy search_strategy;

    public Context(Search_Strategy search_strategy){
        this.search_strategy = search_strategy;
    }
    public void executeStrategy(String search_contents, JTextField jTextField){
        search_strategy.doOperation(search_contents,jTextField);
    }
}
