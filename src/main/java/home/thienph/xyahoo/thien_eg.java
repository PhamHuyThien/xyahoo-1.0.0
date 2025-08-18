package home.thienph.xyahoo;

import javax.microedition.io.ConnectionNotFoundException;

final class thien_eg
implements thien_ae {
    private final String a;

    thien_eg(thien_di thien_di2, String string) {
        this.a = string;
    }

    public final void a() {
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
