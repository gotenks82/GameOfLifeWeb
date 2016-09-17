package com.gameoflife.model;

/**
 * Created by alexpedini on 17/09/16.
 */
public class Universe {

    private int[][] universe;

    /**
     * Builds a universe of the given size where every cell is dead by default
     * @param sizeX rows
     * @param sizeY columns
     */
    public Universe(int sizeX, int sizeY) {
        // setting default minimum size to 3, so that at least 1 cell has 8 neighbours.
        if (sizeX < 3) sizeX = 3;
        if (sizeY < 3) sizeY = 3;

        universe = new int[sizeX][sizeY];
        for (int i=0; i < sizeX; i++) {
            for (int j=0; j < sizeY; j++) {
                setState(i,j,false);
            }
        }
    }

    public int getSizeX() {
        return universe.length;
    }

    public int getSizeY() {
        return universe[0].length;
    }

    public void setState(int x, int y, boolean alive) {
        if (x >= universe.length || y >= universe[0].length)
            return;

        universe[x][y] = alive ? 1 : 0;
    }

    public boolean getState(int x, int y) {
        //cells outside the grid are dead by default
        return isWithinBoundaries(x,y) && universe[x][y] == 1;
    }

    private boolean isWithinBoundaries(int x, int y) {
        return x >= 0 && x < universe.length && y >= 0 && y < universe[0].length;
    }

    public int countAliveNeighbours(int x, int y) {
        int aliveNeighbours = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ((i != x || j != y) && isWithinBoundaries(i, j))
                    aliveNeighbours += universe[i][j];
            }
        }
        return aliveNeighbours;
    }

}
