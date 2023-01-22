package alt.view;

import alt.model.CellImgType;
import alt.model.Game;

public interface View<I> {

    void showWindow(Game game);
    I getImageByType(CellImgType imgType);
}
