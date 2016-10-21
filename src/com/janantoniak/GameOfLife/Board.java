package com.janantoniak.GameOfLife;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private final int partsHorizontal;
    private final int partsVertical;
    private int brickSizeX;
    private int brickSizeY;
    private Ground ground;

    public Board(int partsHorizontal, int partsVertical, Ground ground) {
        super();
        this.partsHorizontal = partsHorizontal;
        this.partsVertical = partsVertical;
        this.ground = ground;

        setBackground(new Color(60, 63, 65));
        setVisible(true);
    }

    @Override
    public synchronized void paintComponent(Graphics g) {

        brickSizeX = getWidth()/partsHorizontal;
        brickSizeY = getHeight()/partsVertical;

        super.paintComponent(g);
        for(int x = 0; x < partsHorizontal; x++) {
            for(int y = 0; y < partsVertical; y++) {
                int type = ground.isAlive(x,y) ? 1 : 0;
                if(type != 0) {
                    drawBrick(x * brickSizeX, y * brickSizeY, g);
                }
            }
        }

        g.setColor(Color.BLACK);
        for(int x = 0; x < partsHorizontal; x++) {
            for(int y = 0; y < partsVertical; y++) {
                g.drawLine(x * brickSizeX, 0, x * brickSizeX, getHeight());
                g.drawLine(0, y * brickSizeY, getWidth(), y * brickSizeY);
            }
        }
    }

    private synchronized void drawBrick(int x, int y, Graphics g) {
                g.setColor(Color.BLUE);
                g.fillRect(x, y, brickSizeX, brickSizeY);
    }


}
