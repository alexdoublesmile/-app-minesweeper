package alt.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Cell {
    private int row;
    private int column;
    private CellType type;
    private boolean isOpen;
    private boolean isFlagged;
    private boolean isLosing;

    @ToString.Exclude
    @Builder.Default
    private List<Cell> aroundCells = new ArrayList<>();
}
