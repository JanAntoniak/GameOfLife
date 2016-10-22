package com.janantoniak.GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameOfLife {

    private Ground ground;
    private Window window;
    private Board board;
    private static int x;
    private static int y;

    public GameOfLife(final int x, final int y) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                GameOfLife.x = x;
                GameOfLife.y = y;

                ground = new Ground(x,y);
                ArrayList<Point> list = new ArrayList<Point>() {{
                    add(new Point(3, 4)); add(new Point(3, 5));
                    add(new Point(3, 6)); add(new Point(1, 1));
                    add(new Point(2, 1)); add(new Point(1, 2));
                    add(new Point(7, 7)); add(new Point(7, 8));
                    add(new Point(7, 9)); add(new Point(8, 8));
                    add(new Point(8, 9)); add(new Point(8, 10));

                    add(new Point(20,20)); add(new Point(21,20));
                    add(new Point(20,21)); add(new Point(21,21));
                    add(new Point(24,20)); add(new Point(25,20));
                    add(new Point(25,19)); add(new Point(25,21));
                    add(new Point(26,22)); add(new Point(26,18));
                    add(new Point(27,20)); add(new Point(28,23));
                    add(new Point(29,23)); add(new Point(28,17));
                    add(new Point(29,17)); add(new Point(30,22));
                    add(new Point(30,18)); add(new Point(31,19));
                    add(new Point(31,20)); add(new Point(31,21));
                    add(new Point(36,22)); add(new Point(39,22));
                    add(new Point(40,22)); add(new Point(41,22));
                    add(new Point(41,21)); add(new Point(40,20));
                    add(new Point(45,21)); add(new Point(45,20));
                    add(new Point(45,16)); add(new Point(45,15));
                    add(new Point(47,16)); add(new Point(47,20));
                    add(new Point(48,17)); add(new Point(48,18));
                    add(new Point(48,19)); add(new Point(49,17));
                    add(new Point(49,18)); add(new Point(49,19));
                    add(new Point(54,19)); add(new Point(54,18));
                    add(new Point(55,19)); add(new Point(55,18));

                }};

                /**
                 * Some random generated alive cells
                 */

                Point point;
                Random rm = new Random();
                for (int i = 0; i < 1000; ++i) {
                    if(!list.contains(point = new Point(rm.nextInt(99), rm.nextInt(100)))) {
                        list.add(point);
                    }
                    else
                        --i;
                }

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
            ground.setCellStatus(p.x, p.y, Cell.Status.ALIVE);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gol = new GameOfLife(100,100);
    }
}
