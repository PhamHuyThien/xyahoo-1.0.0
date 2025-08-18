package home.thienph.xyahoo;

final class thien_dr
implements thien_ae {
    private thien_di a;
    private final thien_at b;
    private final String c;
    private final thien_ap d;

    thien_dr(thien_di thien_di2, thien_at thien_at2, String string, thien_ap thien_ap2) {
        this.a = thien_di2;
        this.b = thien_at2;
        this.c = string;
        this.d = thien_ap2;
    }

    public final void a() {
        MessageHandler.a(false, this.b.c(), this.c);
        this.a.c(this.d);
    }
}
