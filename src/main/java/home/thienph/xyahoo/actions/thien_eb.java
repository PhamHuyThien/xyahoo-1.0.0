package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_eb implements IAction {
    private GameManager gameManager;

    public thien_eb(GameManager gameManager2) {
        this.gameManager = gameManager2;
    }

    public final void action() {
        ConnectionManager.disconnect();
        this.gameManager.closeTopDialog();
    }
}
