package com.janantoniak.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameOfLife {

    private Ground ground;
    private Window window;
    private Board board;

    public GameOfLife() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                int x,y;
                x = 20;
                y = 20;

                ground = new Ground(x,y);
                ArrayList<Point> list = new ArrayList<Point>() {{
                        add(new Point(3, 4)); add(new Point(3, 5));
                        add(new Point(3, 6)); add(new Point(1, 1));
                        add(new Point(2, 1)); add(new Point(1, 2));
                        add(new Point(7, 7)); add(new Point(7, 8));
                        add(new Point(7, 9)); add(new Point(8, 8));
                        add(new Point(8, 9)); add(new Point(8, 10));
                }};
                addStartingPoints(list);


                window = new Window();
                board = new Board(x, y, ground);
                window.add(board);
                window.pack();
                window.setLocationRelativeTo(null);
            }
        });
    }

    private void addStartingPoints(ArrayList<Point> list) {

        for (Point p: list) {
            ground.setCellStatus(p.x, p.y, 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gol = new GameOfLife();
    }
}
