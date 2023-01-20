package model;

import util.Ranges;

public class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;
    private int totalFlags;

    public void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().getX() * Ranges.getSize().getY();
    }

    public Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
    }

    public void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED: setClosedToBox(coord);
            break;
            case CLOSED: setFlaggedToBox(coord);
            break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }

    public int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }

    public void setBombToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    public void setOpenedToClosedBombBox(Coord coord) {
        if (flagMap.get(coord) == Box.CLOSED) {
            flagMap.set(coord, Box.OPENED);
        }
    }

    public void setNoBombToFlaggedSafeBox(Coord coord) {
        if (flagMap.get(coord) == Box.FLAGGED) {
            flagMap.set(coord, Box.NOBOMB);
        }
    }

    public int getCountOfFlaggedBoxesAround(Coord coord) {
        int flagCount = 0;
        for (Coord aroundCoord : Ranges.getCoordsAround(coord)) {
            if (flagMap.get(aroundCoord) == Box.FLAGGED) {
                flagCount++;
            }
        }
        return flagCount;
    }
}
