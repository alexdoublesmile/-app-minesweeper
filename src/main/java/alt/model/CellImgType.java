package alt.model;

import alt.exception.IncorrectCellTypeException;

public enum CellImgType {
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,
    OPENED,
    CLOSED,
    FLAGGED,
    BOMBED,
    NOBOMB;

    public static CellImgType getByCell(Cell cell) {
        if (!cell.isOpen()) {
            if (cell.isFlagged()) {
                return FLAGGED;
            } else {
                return CLOSED;
            }
        } else {
            if (CellType.EMPTY == cell.getType() && !cell.isFlagged()) {
                return OPENED;
            }
            if (CellType.NUMBER == cell.getType() && !cell.isFlagged()) {
                final int numberOfBombsAround = (int) cell.getAroundCells()
                        .stream()
                        .filter(aroundCell -> CellType.BOMB == aroundCell.getType())
                        .count();

                switch (numberOfBombsAround) {
                    case 1: return NUM1;
                    case 2: return NUM2;
                    case 3: return NUM3;
                    case 4: return NUM4;
                    case 5: return NUM5;
                    case 6: return NUM6;
                    case 7: return NUM7;
                    case 8: return NUM8;
                    default: throw new IncorrectCellTypeException(cell);
                }
            }

            if (CellType.BOMB == cell.getType()) {
                if (cell.isLosing()) {
                    return BOMBED;
                } else {
                    return BOMB;
                }
            }

            if (CellType.BOMB != cell.getType() && cell.isFlagged()) {
                return NOBOMB;
            }
        }
        return null;
    }
}
