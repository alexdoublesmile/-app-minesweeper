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
}
