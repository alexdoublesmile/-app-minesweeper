package alt.view.swing;

import alt.exception.IncorrectCellTypeException;
import alt.model.Cell;
import alt.model.CellType;

public enum CellImgType {
    EMPTY("zero"),
    ONE("num1"),
    TWO("num2"),
    THREE("num3"),
    FOUR("num4"),
    FIVE("num5"),
    SIX("num6"),
    SEVEN("num7"),
    EIGHT("num8"),
    BOMB("bomb"),
    CLOSED("closed"),
    FLAGGED("flagged"),
    BOMBED("bombed"),
    FALSE_FLAG("nobomb");

    CellImgType(String imgName) {
        this.imgName = imgName;
    }

    private String imgName;

    public String getImgName() {
        return imgName;
    }

    public static CellImgType getByCell(Cell cell) {
        if (!cell.isOpen()) {
            if (cell.isFlagged()) {
                return FLAGGED;
            } else {
                return CLOSED;
            }
        } else {
            if (CellType.EMPTY == cell.getType() && !cell.isFlagged()) {
                return EMPTY;
            }
            if (CellType.NUMBER == cell.getType() && !cell.isFlagged()) {
                final int numberOfBombsAround = (int) cell.getAroundCells()
                        .stream()
                        .filter(aroundCell -> CellType.BOMB == aroundCell.getType())
                        .count();

                switch (numberOfBombsAround) {
                    case 1: return ONE;
                    case 2: return TWO;
                    case 3: return THREE;
                    case 4: return FOUR;
                    case 5: return FIVE;
                    case 6: return SIX;
                    case 7: return SEVEN;
                    case 8: return EIGHT;
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
                return FALSE_FLAG;
            }
        }
        return EMPTY;
    }
}
