package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_dm
implements IAction {
    final GameManager gameManager;
    private final String b;
    private final IAction c;

    public thien_dm(GameManager gameManager2, String string, IAction IAction2) {
        this.gameManager = gameManager2;
        this.b = string;
        this.c = IAction2;
    }

    public final void action() {
        this.gameManager.closeTopDialog();
        Xuka.startThread(this.b, this.gameManager.getCardSyntax(), new thien_dn(this), new thien_do(this, this.c), false);
    }
}
