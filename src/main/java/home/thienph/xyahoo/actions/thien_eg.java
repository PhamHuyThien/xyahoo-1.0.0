package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;

import javax.microedition.io.ConnectionNotFoundException;

public final class thien_eg
implements IAction {
    private final String a;

    public thien_eg(GameManager gameManager2, String string) {
        this.a = string;
    }

    public final void action() {
        try {
            Xuka.instance.platformRequest(this.a);
        }
        catch (ConnectionNotFoundException connectionNotFoundException) {}
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException interruptedException) {
        }
        Xuka.instance.stopApp();
    }
}
