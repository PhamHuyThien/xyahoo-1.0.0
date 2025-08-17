package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_em
extends thien_an {
    thien_al w;
    int x;
    private Vector A;
    thien_am y;
    public static thien_ab z = new thien_ab("N\u1ea1p xuxu", new thien_en());

    public thien_em() {
        this.p = true;
        this.w = new thien_al(1, 1, thien_an.e - 3, thien_an.f - 2 - thien_di.g, 0);
        this.a(this.w);
        this.c(this.w);
        this.l = new thien_ab("T\u00ecm ph\u00f2ng", new thien_eo(this));
        this.A = new Vector();
        this.A.addElement(new thien_ab(thien_as.bB(), new thien_ep(this)));
        this.A.addElement(z);
        this.A.addElement(new thien_ab(thien_as.ae(), new thien_eq(this)));
        this.y = new thien_am(this.A);
        this.k = new thien_ab("Menu", new thien_er(this));
    }

    public final void d() {
        this.w.f();
    }

    public final void d(Graphics graphics) {
        this.w.c(graphics);
    }
}
