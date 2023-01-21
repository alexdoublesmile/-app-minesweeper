package alt.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Field {
    Info info;
    Menu menu;

    private Cell[][] cells;
}
