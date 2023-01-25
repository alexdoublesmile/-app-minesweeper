package view.swing.menu;

import lombok.Builder;

@Builder
public class CustomParams {
    private int rows;
    private int columns;
    private int bombs;

    public String normalizedRows() {
        return null;// TODO: 25.01.2023
    }

    public String normalizedColumns() {
        return null;// TODO: 25.01.2023
    }

    public String normalizedBombs() {
        return null;// TODO: 25.01.2023
    }
}
