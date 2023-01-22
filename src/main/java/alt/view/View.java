package alt.view;

import alt.model.Game;

public interface View {
    void showWindow(Game model);

    ViewAction getAction();

    void showAction(Game model);
}
