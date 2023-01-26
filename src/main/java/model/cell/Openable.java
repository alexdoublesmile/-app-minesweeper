package model.cell;

import model.Field;

public interface Openable {
    default void openCell(int row, int col, Field field) {};
}
