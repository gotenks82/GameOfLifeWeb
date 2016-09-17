package com.gameoflife.model;

import com.gameoflife.model.Universe;

/**
 * Created by alexpedini on 17/09/16.
 */
public class Evolution {

    public static Universe evolve(Universe universe) {
        Universe evolved = new Universe(universe.getSizeX(), universe.getSizeY());

        for (int i = 0; i < evolved.getSizeX(); i++) {
            for (int j = 0; j < evolved.getSizeY(); j++) {
                evolved.setState(i,j, nextState(universe, i, j));
            }
        }

        return evolved;
    }

    /**
     * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
     * Any live cell with two or three live neighbours lives on to the next generation.
     * Any live cell with more than three live neighbours dies, as if by over-population.
     * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     * @param universe
     * @param x
     * @param y
     * @return
     */
    public static boolean nextState(Universe universe, int x, int y) {
        int aliveNeighbours = universe.countAliveNeighbours(x,y);
        return (!(aliveNeighbours < 2 || aliveNeighbours > 3)) && (aliveNeighbours != 2 || universe.getState(x,y));
    }
}
