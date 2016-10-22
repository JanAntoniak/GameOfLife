package com.janantoniak.GameOfLife;

public class Ground {

    private Cell[][] ground;
    private int width;
    private int height;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
        ground = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                ground[i][j] = new Cell(i,j);
            }
        }
    }

    public boolean isAlive(int i, int j) {
        return ground[i][j].isAlive();
    }

    public int countNeighbour(int i, int j) {
        int result = 0, fromX, toX, fromY, toY;

        fromX = Math.max(i-1, 0);
        toX = Math.min(i+2, width);
        fromY = Math.max(j-1, 0);
        toY = Math.min(j+2, height);

        for (int k = fromX; k < toX; k++) {
            for (int l = fromY; l < toY; l++) {
                if(ground[k][l].isAlive())
                    result += 1;
            }
        }
        if(ground[i][j].isAlive())
            result -= 1;
        return result;
    }

    public void setCellStatus(int i, int j, Cell.Status status) {
        if(Cell.Status.DEAD == status)
            ground[i][j].setDead();
        else if(Cell.Status.ALIVE == status)
            ground[i][j].setAlive();
    }

    public Cell getCell(int i, int j) {
        return ground[i][j];
    }

    public void nextCycle() {
        int numberOfNeighbours;
        Cell temp[][] = cloneGround();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                numberOfNeighbours = this.countNeighbour(i,j);
                if(ground[i][j].isAlive() && (2 != numberOfNeighbours && 3 != numberOfNeighbours)) {
                    temp[i][j].setDead();
                }
                else if(!ground[i][j].isAlive() && 3 == numberOfNeighbours) {
                    temp[i][j].setAlive();
                }
            }
        }
        ground = temp;
    }

    private Cell[][] cloneGround() {
        Cell temp[][] = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                temp[i][j] = new Cell(ground[i][j]);
            }
        }
        return temp;
    }

}
