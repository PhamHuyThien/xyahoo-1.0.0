package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

final class thien_gw
implements thien_ae {
    private thien_gp a;

    thien_gw(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void a() {
        if (!this.a.C) {
            thien_di.c.a(thien_as.au(), (Image)null, 1);
            return;
        }
        this.a.h();
    }
}
