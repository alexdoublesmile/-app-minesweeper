package alt.view;

import alt.model.Field;
import alt.model.Game;

public interface View {
    void showWindow(Field field);

    ViewAction getAction();

    void showAction(Game model);
}
