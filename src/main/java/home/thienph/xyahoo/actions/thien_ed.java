package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

public final class thien_ed
implements IAction {
    private GameManager gameManager;

    public thien_ed(GameManager gameManager2) {
        this.gameManager = gameManager2;
    }

    public final void action() {
        this.gameManager.closeTopDialog();
    }
}
