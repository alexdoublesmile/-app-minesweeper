package alphaversion.model;

import alphaversion.util.Ranges;

public class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    public Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    public void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    private void placeBomb() {
        Coord randomCoord;
        do {
            randomCoord = Ranges.getRandomCoord();
        } while (Box.BOMB == bombMap.get(randomCoord));

        bombMap.set(randomCoord, Box.BOMB);
        incNumbersAroundBomb(randomCoord);
    }

    private void incNumbersAroundBomb(Coord bombCoord) {
        for (Coord coord : Ranges.getCoordsAround(bombCoord)) {
            if (Box.BOMB != bombMap.get(coord)) {
                bombMap.set(coord, bombMap.get(coord).nextNumberBox());
            }
        }
    }

    private void fixBombsCount() {
        int maxBombs = Ranges.getSize().getX() * Ranges.getSize().getY() / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    public Box get(Coord coord) {
        return bombMap.get(coord);
    }

    public int getTotalBombs() {
        return totalBombs;
    }
}
