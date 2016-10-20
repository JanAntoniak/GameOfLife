package com.janantoniak.tests;

import com.janantoniak.GameOfLife.*;
import org.junit.Assert;

public class CellTest {
    @org.junit.Test
    public void testCreate() {
        Cell cell = new Cell(3,2);
        Assert.assertNotNull(cell);
        Assert.assertEquals(3, cell.getX());
        Assert.assertEquals(2, cell.getY());
        Assert.assertEquals(cell.isAlive(), false);
    }

    @org.junit.Test
    public void testChangeCellState() {
        Cell cell = new Cell(4,5);

        cell.setAlive();
        Assert.assertEquals(cell.isAlive(), true);

        cell.setDead();
        Assert.assertEquals(cell.isAlive(), false);
    }
}