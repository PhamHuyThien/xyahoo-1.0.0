package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;

public final class thien_ef
implements IAction {
    private GameManager gameManager;
    private final String b;
    private final String c;

    public thien_ef(GameManager gameManager2, String string, String string2) {
        this.gameManager = gameManager2;
        this.b = string;
        this.c = string2;
    }

    public final void action() {
        MessageHandler.a(this.b, false, "", this.c);
        this.gameManager.closeTopDialog();
    }
}
