package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class thien_dz implements IAction {
    private GameManager gameManager;
    private final String b;

    public thien_dz(GameManager gameManager2, String string) {
        this.gameManager = gameManager2;
        this.b = string;
    }

    public final void action() {
        MessageHandler.c(LoginYahooScreen.currentUsername, this.b, 0);
        this.gameManager.closeTopDialog();
    }
}
