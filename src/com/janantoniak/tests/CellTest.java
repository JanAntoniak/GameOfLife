package com.janantoniak.tests;

import com.janantoniak.GameOfLife.*;
import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    @Test
    public void testCreate() {
        Cell cell = new Cell(3,2);
        Assert.assertEquals(3, cell.getX());
        Assert.assertEquals(2, cell.getY());
        Assert.assertEquals(cell.isAlive(), false);
    }

    @Test
    public void testChangeCellState() {
        Cell cell = new Cell(4,5);
        Cell cell2 = new Cell(6,6);

        cell.setAlive();
        Assert.assertEquals(cell.isAlive(), true);

        cell.setDead();
        Assert.assertEquals(cell.isAlive(), false);

        cell2.setDead();
        Assert.assertEquals(cell2.isAlive(), false);
    }
}