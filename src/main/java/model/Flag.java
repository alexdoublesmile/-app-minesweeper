package model;

public class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    public void start() {
        flagMap = new Matrix(Box.CLOSED);
    }

    public Box get(Coord coord) {
        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
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
}
