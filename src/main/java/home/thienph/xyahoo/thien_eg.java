package home.thienph.xyahoo;

import javax.microedition.io.ConnectionNotFoundException;

final class thien_eg
implements IAction {
    private final String a;

    thien_eg(GameManager gameManager2, String string) {
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
