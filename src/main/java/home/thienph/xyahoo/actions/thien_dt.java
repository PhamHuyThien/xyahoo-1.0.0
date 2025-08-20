package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.FormScreen;

public final class thien_dt implements IAction {
    private GameManager gameManager;
    private final FormScreen
            formScreen;

    public thien_dt(GameManager gameManager2, FormScreen formScreen2) {
        this.gameManager = gameManager2;
        this.formScreen = formScreen2;
    }

    public final void action() {
        this.gameManager.removeScreen(this.formScreen);
    }
}
