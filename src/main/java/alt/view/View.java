package alt.view;

import alt.model.Game;

public interface View {
    void showWindow();

    ViewAction getAction();

    void showAction(Game model);

    void activateInteractions();
}
