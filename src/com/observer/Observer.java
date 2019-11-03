package com.observer;

import javax.swing.*;

public interface Observer {
    public abstract void update(JTextArea textArea,JTextPane textPane);
}
