package home.thienph.xyahoo;

import java.util.Vector;

final class thien_cz
implements thien_ae {
    private thien_cq a;

    thien_cz(thien_cq thien_cq2) {
        this.a = thien_cq2;
    }

    public final void a() {
        int n;
        System.gc();
        this.a.D.a(this.a.D.c().toLowerCase());
        thien_ff.A = thien_ff.y = this.a.D.c();
        thien_ff.B = 1;
        Xuka.f(this.a.D.c());
        Xuka.c(this.a.E.c());
        Xuka.a("status", true);
        if (thien_di.c.j == null) {
            thien_di.c.j = new thien_ff();
            thien_di.c.m = new thien_cn();
        }
        if ((n = thien_di.a(false)) != -1) {
            thien_s thien_s2 = thien_di.a(false, thien_ff.y);
            if (thien_s2 != null) {
                thien_di.b().j.x.a(thien_s2, -1);
            } else {
                n = -1;
            }
        }
        thien_di.b().d = new Vector();
        thien_d.a.a();
        thien_a.a(this.a.D.c(), this.a.E.c(), thien_ff.B, 1, n);
    }
}
