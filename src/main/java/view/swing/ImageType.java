package view.swing;

import exception.IncorrectCellTypeException;
import model.cell.Cell;
import model.cell.CellType;

public enum ImageType {
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

    ImageType(String imageName) {
        this.imageName = imageName;
    }

    private final String imageName;

    public String getImageName() {
        return imageName;
    }

    public static ImageType getByCell(Cell cell) {
        return cell.isOpen() ? getByOpenCell(cell) : getByClosedCell(cell);
    }

    private static ImageType getByOpenCell(Cell cell) {
        return cell.isBomb() ? getBombType(cell) : getSafeType(cell);
    }

    private static ImageType getByClosedCell(Cell cell) {
        return cell.isFlagged() ? FLAGGED : CLOSED;
    }

    private static ImageType getBombType(Cell cell) {
        return cell.isLosing() ? BOMBED : BOMB;
    }

    private static ImageType getSafeType(Cell cell) {
        return cell.isFlagged()
                ? FALSE_FLAG
                : cell.isEmpty() ? EMPTY : getNumberType(cell);
    }

    private static ImageType getNumberType(Cell cell) {
        switch (countBombsAround(cell)) {
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

    private static int countBombsAround(Cell cell) {
        return (int) cell.getAroundCells()
                .stream()
                .filter(aroundCell -> CellType.BOMB == aroundCell.getType())
                .count();
    }
}
