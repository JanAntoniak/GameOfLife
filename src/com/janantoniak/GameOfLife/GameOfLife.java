package com.janantoniak.GameOfLife;

public class GameOfLife {

    private Ground ground;
    private Window window;
    private Board board;

    public GameOfLife() {
        int x,y;
        x = 20;
        y = 20;
        ground = new Ground(x,y);
        ground.setCellStatus(3,4,1);
        ground.setCellStatus(3,5,1);
        ground.setCellStatus(3,6,1);

        ground.setCellStatus(1,1,1);
        ground.setCellStatus(2,1,1);
        ground.setCellStatus(1,2,1);
        ground.setCellStatus(2,1,1);

        window = new Window();
        board = new Board(x, y, ground);
        window.add(board);
    }

    public synchronized void execute() throws InterruptedException {
        while(true) {
            ground.nextCycle();
            board.repaint();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gol = new GameOfLife();
        gol.execute();
    }

}
