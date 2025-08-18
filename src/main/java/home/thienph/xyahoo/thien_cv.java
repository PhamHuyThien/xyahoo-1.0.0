package home.thienph.xyahoo;

final class thien_cv
implements thien_ae {
    private final thien_x a;
    private final thien_x b;
    private final thien_z c;
    private final thien_x d;
    private final thien_x e;

    thien_cv(thien_x thien_x2, thien_x thien_x3, thien_z thien_z2, thien_x thien_x4, thien_x thien_x5) {
        this.a = thien_x2;
        this.b = thien_x3;
        this.c = thien_z2;
        this.d = thien_x4;
        this.e = thien_x5;
    }

    public final void a() {
        thien_di.b().l.a(1);
        thien_di.b().c(thien_cq.i());
        if (thien_di.r != this.a.a) {
            thien_di.r = this.a.a;
            Xuka.saveFlag("atlog", thien_di.r);
        }
        if (thien_di.s != this.b.a) {
            thien_di.s = this.b.a;
            Xuka.saveFlag("atlogY", thien_di.s);
        }
        if (thien_at.c != this.c.a()) {
            thien_at.c = this.c.a();
            Xuka.saveCaret(thien_at.c);
        }
        if (thien_di.q != this.d.a) {
            thien_di.q = this.d.a;
            Xuka.saveFlag("vibrate", thien_di.q);
        }
        if (thien_di.p != !this.e.a) {
            thien_di.p = !this.e.a;
            Xuka.saveFlag("sound", thien_di.p);
        }
    }
}
