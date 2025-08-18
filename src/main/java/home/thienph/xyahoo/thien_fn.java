package home.thienph.xyahoo;

final class thien_fn
implements thien_ae {
    private final thien_at a;
    private final thien_z b;
    private final thien_an c;

    thien_fn(thien_ff thien_ff2, thien_at thien_at2, thien_z thien_z2, thien_an thien_an2) {
        this.a = thien_at2;
        this.b = thien_z2;
        this.c = thien_an2;
    }

    public final void a() {
        String string = thien_fe.b(this.a.c().trim());
        int n = this.b.a() == 0 ? 1 : 0;
        if (n != thien_ff.B) {
            MessageHandler.a(n, 1);
            thien_ff.B = n;
        }
        if (thien_ff.B == 1) {
            MessageHandler.a(string, 1);
            thien_ff.D = string;
            Xuka.saveCustomStr(thien_ff.y, thien_ff.D, false);
        }
        thien_di.b().c(this.c);
        thien_di.c.l();
    }
}
