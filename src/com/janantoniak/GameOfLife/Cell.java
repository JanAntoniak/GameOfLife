package com.janantoniak.GameOfLife;

public class Cell {

    private int positionX;
    private int positionY;
    public enum Status {
        ALIVE, DEAD
    }
    Cell.Status status;

    public Cell(Cell cell) {
        this.positionX = cell.positionX;
        this.positionY = cell.positionY;
        this.status = cell.status;
    }

    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.status = Status.DEAD;
    }

    public boolean isAlive() {
        return (Status.ALIVE == status);
    }

    public void setAlive() {
        this.status = Status.ALIVE;
    }

    public void setDead() {
        this.status = Status.DEAD;
    }

    public int getX() {
        return this.positionX;
    }

    public int getY() {
        return this.positionY;
    }
}
