package com.janantoniak.GameOfLife;

public class Cell {

    private int positionX;
    private int positionY;
    private final int DEAD = 0;
    private final int ALIVE = 1;
    private int status;

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = DEAD;
    }

    public boolean isAlive() {
        return (ALIVE == status);
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
