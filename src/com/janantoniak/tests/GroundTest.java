package com.janantoniak.tests;

import com.janantoniak.GameOfLife.Ground;

import org.junit.Assert;
import org.junit.Test;

public class GroundTest {

    @Test
    public void testCreate() {
        Ground ground = new Ground(10,10);

        Assert.assertNotNull(ground);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Assert.assertNotNull(ground.getCell(i,j));
                Assert.assertEquals(ground.isAlive(i,j), false);
            }
        }
    }

    @Test
    public void testDieLonely() {
        Ground ground = new Ground(5,5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ground.setCellStatus(i, j, 0);
            }
        }
        ground.setCellStatus(1,1,1);
        ground.nextCycle();
        Assert.assertEquals(ground.isAlive(1,1), false);
    }

    @Test
    public void testDieOvercrowded() {
        Ground ground = new Ground(5,5);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ground.setCellStatus(i,j, 1);
            }
        }
        ground.nextCycle();
        Assert.assertEquals(ground.isAlive(1,1), false);
    }

    @Test
    public void testCreateNewOrganism() {
        Ground ground = new Ground(6,6);

        ground.setCellStatus(1,1,1);
        ground.setCellStatus(2,1,1);
        ground.setCellStatus(3,1,1);

        ground.nextCycle();

        Assert.assertEquals(ground.isAlive(2,0), true);
        Assert.assertEquals(ground.isAlive(2,2), true);
    }

    @Test
    public void testSetCellStatus() {
        Ground ground = new Ground(4,5);
        ground.setCellStatus(1,3,1);

    }

    @Test
    public void testCountNeighbour() throws Exception {
        Ground ground = new Ground(10, 10);
        ground.setCellStatus(1,1,1);
        ground.setCellStatus(1,2,1);
        ground.setCellStatus(2,1,1);

        Assert.assertEquals(ground.countNeighbour(2,2), 3);
    }
}