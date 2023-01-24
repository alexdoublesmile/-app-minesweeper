package model.cell;

import lombok.*;
import model.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
//@Builder
@EqualsAndHashCode(of = {"row", "column"})
@NoArgsConstructor
@AllArgsConstructor
public class Cell implements Openable {
    protected int row;
    protected int column;
    protected CellType type;
    protected boolean isOpen;
    protected boolean isFlagged;
    protected boolean isLosing;
    protected Field field;

    @ToString.Exclude
//    @Builder.Default
    protected List<Cell> aroundCells = new ArrayList<>();

    public Cell(int row, int column, CellType type, boolean isOpen) {
        this.row = row;
        this.column = column;
        this.type = type;
        this.isOpen = isOpen;
    }

    public List<Cell> getAroundCells() {
        return new ArrayList<>(aroundCells);
    }

    public void addAroundCell(Cell aroundCell) {
        aroundCells.add(aroundCell);
    }

//    public void makeOpen() {
//        isOpen = true;
//    }

    public void makeLosing() {
        isLosing = true;
    }

//    public void toggleFlag() {
//        if (!isOpen) {
//            if (isFlagged) {
//                isFlagged = false;
//            } else {
//                isFlagged = true;
//            }
//        }
//    }

//    public void makeBomb() {
//        type = CellType.BOMB;
//    }
//
//    public void makeNumber() {
//        type = CellType.NUMBER;
//    }

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

    protected void addAroundCells(List<Cell> cells) {
        cells.forEach(cell -> aroundCells.add(field.getCells()[cell.getRow()][cell.getColumn()]));
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void toggleFlag() {
        if (isClosed()) {
            isFlagged = !isFlagged;
        }
    }
}
