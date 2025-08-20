package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

public final class thien_ec
implements IAction {
    private GameManager gameManager;

    public thien_ec(GameManager gameManager2) {
        this.gameManager = gameManager2;
    }

    public final void action() {
        System.out.println("ccoooooooooooooo");
        this.gameManager.closeTopDialog();
    }
}
