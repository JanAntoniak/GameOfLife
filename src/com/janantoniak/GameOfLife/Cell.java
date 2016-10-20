package com.janantoniak.GameOfLife;

public class Cell {

    private int positionX;
    private int positionY;
    private int status;
    public final static int DEAD = 0;
    public final static int ALIVE = 1;

    public Cell(Cell cell) {
        this.positionX = cell.positionX;
        this.positionY = cell.positionY;
        this.status = cell.status;
    }

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = DEAD;
    }

    public boolean isAlive() {
        return (ALIVE == status);
    }

    public int getStatus() {
        return status;
    }

    public int getX() {
        return this.positionX;
    }

    public int getY() {
        return this.positionY;
    }

    public void setAlive() {
        this.status = ALIVE;
    }

    public void setDead() {
        this.status = DEAD;
    }
}
