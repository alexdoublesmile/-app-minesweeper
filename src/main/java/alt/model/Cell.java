package alt.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
public class Cell {
    private int row;
    private int column;
    private int size;
    private CellType type;
    private boolean isOpen;
    private boolean isFlagged;

    @Builder.Default
    private List<Cell> aroundCells = new ArrayList<>();
}
