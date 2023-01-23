package view;

public interface View {

    void showWindow();

    void activateInteractions();

    void updateModel();

    default ViewAction getAction() {
        return null;
    };
}
