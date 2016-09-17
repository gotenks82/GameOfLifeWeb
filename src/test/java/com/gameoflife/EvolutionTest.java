package com.gameoflife;

import com.gameoflife.model.Evolution;
import com.gameoflife.model.Universe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by alexpedini on 17/09/16.
 */
public class EvolutionTest {

    @Test
    public void testNextState() {
        // starting from a universe
        Universe universe = new Universe(10,10);
        // with vertical "blinker" formation
        universe.setState(1,2, true);
        universe.setState(2,2, true);
        universe.setState(3,2, true);

        // the next state will describe a horizontal formation
        assertEquals(false, Evolution.nextState(universe, 1, 0));
        assertEquals(false, Evolution.nextState(universe, 1, 1));
        assertEquals(false, Evolution.nextState(universe, 1, 2));
        assertEquals(false, Evolution.nextState(universe, 1, 3));

        assertEquals(false, Evolution.nextState(universe, 2, 0));
        assertEquals(true, Evolution.nextState(universe, 2, 1));
        assertEquals(true, Evolution.nextState(universe, 2, 2));
        assertEquals(true, Evolution.nextState(universe, 2, 3));

        assertEquals(false, Evolution.nextState(universe, 3, 0));
        assertEquals(false, Evolution.nextState(universe, 3, 1));
        assertEquals(false, Evolution.nextState(universe, 3, 2));
        assertEquals(false, Evolution.nextState(universe, 3, 3));
    }

    @Test
    public void testUniverseEvolution() {
        // starting from a universe
        Universe firstGeneration = new Universe(10,10);
        // with vertical "blinker" formation
        firstGeneration.setState(1,2, true);
        firstGeneration.setState(2,2, true);
        firstGeneration.setState(3,2, true);

        Universe secondGeneration = Evolution.evolve(firstGeneration); // will be an horizontal blinker
        Universe thirdGeneration = Evolution.evolve(secondGeneration); // will be again a vertical blinker

        assertEquals(true, isVerticalBlinker(firstGeneration));
        assertEquals(true, isHorizontalBlinker(secondGeneration));
        assertEquals(true, isVerticalBlinker(thirdGeneration));
    }

    // verifies that there is a blinker in vertical position
    private static boolean isVerticalBlinker(Universe universe) {
        return universe.getState(1,2) && universe.getState(2,2) && universe.getState(3,2) &&
                !universe.getState(2,1) && !universe.getState(2,3);
    }

    // verifies that there is a blinker in horizontal position
    private static boolean isHorizontalBlinker(Universe universe) {
        return universe.getState(2,1) && universe.getState(2,2) && universe.getState(2,3) &&
                !universe.getState(1,2) && !universe.getState(3,2);
    }
}
