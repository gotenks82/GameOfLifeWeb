package com.gameoflife;

import com.gameoflife.model.Universe;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alexpedini on 17/09/16.
 */
public class UniverseTest {

    @Test
    public void testUniverseCreation() {
        Universe universe = new Universe(5, 10);
        assertEquals(5, universe.getSizeX());
        assertEquals(10, universe.getSizeY());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(false, universe.getState(i,j));
            }
        }
    }

    @Test
    public void testState() {
        Universe universe = new Universe(10,10);
        universe.setState(0,0,true);
        assertEquals(true,universe.getState(0,0));
        assertEquals(false,universe.getState(1,0));
        assertEquals(false,universe.getState(0,1));
        assertEquals(false,universe.getState(1,1));
    }

    @Test
    public void testCountAliveNeighbours() {
        Universe universe = new Universe(10,10);
        // "boat" formation alive
        universe.setState(1,1, true);
        universe.setState(1,2, true);
        universe.setState(2,1, true);
        universe.setState(2,3, true);
        universe.setState(3,2, true);

        assertEquals(1, universe.countAliveNeighbours(0, 0));
        assertEquals(2, universe.countAliveNeighbours(0, 1));
        assertEquals(2, universe.countAliveNeighbours(0, 2));
        assertEquals(1, universe.countAliveNeighbours(0, 3));
        assertEquals(0, universe.countAliveNeighbours(0, 4));
        assertEquals(2, universe.countAliveNeighbours(1, 0));
        assertEquals(2, universe.countAliveNeighbours(1, 1));
        assertEquals(3, universe.countAliveNeighbours(1, 2));
        assertEquals(2, universe.countAliveNeighbours(1, 3));
        assertEquals(1, universe.countAliveNeighbours(1, 4));
        assertEquals(2, universe.countAliveNeighbours(2, 0));
        assertEquals(3, universe.countAliveNeighbours(2, 1));
        assertEquals(5, universe.countAliveNeighbours(2, 2));
        assertEquals(2, universe.countAliveNeighbours(2, 3));
        assertEquals(1, universe.countAliveNeighbours(2, 4));
    }

}
