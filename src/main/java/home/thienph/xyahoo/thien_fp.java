package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

final class thien_fp
implements thien_ae {
    private thien_ff a;
    private final thien_at b;
    private final thien_at c;
    private final thien_at d;
    private final thien_an e;

    thien_fp(thien_ff thien_ff2, thien_at thien_at2, thien_at thien_at3, thien_at thien_at4, thien_an thien_an2) {
        this.a = thien_ff2;
        this.b = thien_at2;
        this.c = thien_at3;
        this.d = thien_at4;
        this.e = thien_an2;
    }

    public final void a() {
        if (this.b.c().equals("")) {
            return;
        }
        if (this.c.c().length() < 6 || this.c.c().length() > 64) {
            thien_di.b().a(String.valueOf(thien_as.G()) + thien_as.q(), (Image)null, 1);
            this.a.c(this.c);
            return;
        }
        if (this.c.c().equals("") || this.d.c().equals("") || !this.c.c().equals(this.d.c())) {
            thien_di.b().a(thien_as.ac(), (Image)null, 1);
            this.a.c(this.c);
            return;
        }
        MessageHandler.b("", this.b.c(), this.c.c());
        thien_di.b().c(this.e);
        thien_di.c.l();
    }
}
