package model;

import util.Ranges;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    public void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    private void placeBomb() {
        bombMap.set(Ranges.getRandomCoord(), Box.BOMB);
    }

    public Box get(Coord coord) {
        return bombMap.get(coord);
    }

    public int getTotalBombs() {
        return totalBombs;
    }
}
