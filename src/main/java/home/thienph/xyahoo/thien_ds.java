package home.thienph.xyahoo;

final class thien_ds
implements thien_ae {
    private thien_di a;
    private final thien_at b;
    private final String c;
    private final thien_ap d;

    thien_ds(thien_di thien_di2, thien_at thien_at2, String string, thien_ap thien_ap2) {
        this.a = thien_di2;
        this.b = thien_at2;
        this.c = string;
        this.d = thien_ap2;
    }

    public final void a() {
        if (this.b.c().equals("")) {
            return;
        }
        this.a.j.x.b().a(this.b.c(), new thien_r(this.c, "", 0, "", new int[0], 0, 0));
        this.a.j.x.c();
        thien_ff thien_ff2 = this.a.j;
        thien_ff2.x.d();
        MessageHandler.a(true, this.b.c(), this.c);
        this.a.c(this.d);
    }
}
