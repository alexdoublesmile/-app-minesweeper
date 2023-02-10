package model.cell;

import model.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell implements Openable {
    protected int row;
    protected int column;
    protected CellType type;
    protected boolean isOpen;
    protected boolean isFlagged;
    protected boolean isLosing;
    protected Field field;

    protected List<Cell> aroundCells = new ArrayList<>();

    public Cell(int row, int column, CellType type, boolean isOpen) {
        this.row = row;
        this.column = column;
        this.type = type;
        this.isOpen = isOpen;
    }

    public Cell(int row, int column, CellType type, boolean isOpen, boolean isFlagged, boolean isLosing, Field field, List<Cell> aroundCells) {
        this.row = row;
        this.column = column;
        this.type = type;
        this.isOpen = isOpen;
        this.isFlagged = isFlagged;
        this.isLosing = isLosing;
        this.field = field;
        this.aroundCells = aroundCells;
    }

    public Cell() {
    }

    public List<Cell> getAroundCells() {
        return new ArrayList<>(aroundCells);
    }

    public void addAroundCell(Cell aroundCell) {
        aroundCells.add(aroundCell);
    }

    protected void addAroundCells(List<Cell> cells) {
        cells.forEach(cell -> aroundCells.add(field.getCells()[cell.getRow()][cell.getColumn()]));
    }

    public void makeLosing() {
        isLosing = true;
    }

    public boolean isClosed() {
        return !isOpen;
    }

    public boolean isNotFlagged() {
        return !isFlagged;
    }

    public boolean isBomb() {
        return CellType.BOMB == type;
    }

    public boolean isEmpty() {
        return CellType.EMPTY == type;
    }

    public boolean isNumber() {
        return CellType.NUMBER == type;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void toggleFlag(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return row == cell.row &&
                column == cell.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CellType getType() {
        return type;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public boolean isLosing() {
        return isLosing;
    }

    public Field getField() {
        return field;
    }
}
