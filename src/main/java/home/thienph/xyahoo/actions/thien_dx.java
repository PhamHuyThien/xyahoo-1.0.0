package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.Screen;

public final class thien_dx implements IAction {
    private GameManager gameManager;
    private final Screen screen;

    public thien_dx(GameManager gameManager2, Screen screen2) {
        this.gameManager = gameManager2;
        this.screen = screen2;
    }

    public final void action() {
        this.gameManager.removeScreen(this.screen);
        this.gameManager.goToFirstScreen();
    }
}
