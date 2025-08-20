package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;

public final class thien_ee
implements IAction {
    private GameManager gameManager;
    private final String b;
    private final String c;
    private final String d;

    public thien_ee(GameManager gameManager2, String string, String string2, String string3) {
        this.gameManager = gameManager2;
        this.b = string;
        this.c = string2;
        this.d = string3;
    }

    public final void action() {
        MessageHandler.a(this.b, true, "", this.c);
        this.gameManager.createOrJoinConference(this.b, (String[])null, this.d);
        this.gameManager.closeTopDialog();
    }
}
