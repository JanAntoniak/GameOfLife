package com.janantoniak.GameOfLife;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final int width;
    private final int height;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Window() throws HeadlessException {
        super();
        this.width = (int) screenSize.getWidth()/2;
        this.height = (int) screenSize.getHeight()/2;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The game of life");
        setSize(width,height);
        setVisible(true);
    }
}
