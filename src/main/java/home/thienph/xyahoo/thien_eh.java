package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

public final class thien_eh
extends thien_ap {
    private static String[] H = new String[]{"admin", "administrator", "root", "system", "xuka", "yahoo"};
    public thien_at D;
    private thien_z I;
    public thien_at E;
    private thien_at J;
    private String K;
    public String F;
    public String G;

    public thien_eh() {
        this.g = thien_as.aa();
        this.k = new thien_ab(thien_as.ae(), new thien_ei(this));
        this.m = new thien_ab(thien_as.aa(), new thien_ej(this));
    }

    public final void b(String[] stringArray) {
        this.a();
        this.D = null;
        this.I = null;
        this.E = null;
        this.J = null;
        System.gc();
        thien_ap.e(70, 150);
        this.e();
        this.x = thien_an.f - (thien_w.i * 3 + thien_aq.a + (GameCanvas.screenHeight > 170 ? 55 : 20) + thien_di.g) >> 1;
        thien_y.a((thien_ap)this, thien_aq.c(), false);
        this.x += GameCanvas.screenHeight > 170 ? 18 : 7;
        this.D = thien_y.a((thien_ap)this, "T\u00ean: ", 0, -1);
        this.x += 5;
        this.I = stringArray != null ? thien_y.a((thien_ap)this, thien_as.n(), stringArray) : null;
        this.E = thien_y.a((thien_ap)this, String.valueOf(thien_as.G()) + ":", 2, -1);
        this.x += 5;
        this.J = thien_y.a((thien_ap)this, String.valueOf(thien_as.Z()) + ":", 2, -1);
        if (stringArray != null) {
            this.D.a(this.K);
            this.E.a(this.F);
            this.J.a(this.F);
        }
        this.c(this.D);
    }

    protected final void f() {
        thien_di thien_di2 = thien_di.b();
        thien_di2.b(thien_di2.l);
        thien_di2.d(thien_di2.l);
        thien_di2.l.a(1);
        thien_di2.c(this);
    }

    public final void g() {
        int n = thien_fe.a(this.D.c());
        if (n == 1) {
            thien_di.b().a("ID" + thien_as.q(), (Image)null, 1);
            this.c(this.D);
            return;
        }
        if (n == 2) {
            thien_di.b().a(thien_as.p(), (Image)null, 1);
            this.c(this.D);
            return;
        }
        if (n == 3) {
            thien_di.b().a(thien_as.o(), (Image)null, 1);
            this.c(this.D);
            return;
        }
        n = 0;
        while (n < H.length) {
            if (H[n].equals(this.D.c())) {
                thien_di.b().a(thien_as.ab(), (Image)null, 1);
                this.D.a("");
                this.c(this.D);
                return;
            }
            ++n;
        }
        if (this.E.c().length() < 6 || this.E.c().length() > 64) {
            thien_di.b().a(String.valueOf(thien_as.G()) + thien_as.q(), (Image)null, 1);
            this.c(this.E);
            return;
        }
        if (this.J.c().equals("") || !this.E.c().equals(this.J.c())) {
            thien_di.b().a(thien_as.ac(), (Image)null, 1);
            this.c(this.J);
            return;
        }
        this.D.a(this.D.c().toLowerCase());
        if (this.K != null && this.K.equals(this.D.c())) {
            if (this.I != null) {
                this.G = this.I.b();
                if (this.G == null) {
                    this.G = this.K;
                }
            } else {
                this.G = this.K;
            }
        } else {
            this.G = this.D.c();
        }
        thien_di.b().a(thien_as.ad(), null, new thien_ab(thien_as.z(), new thien_ek(this)), null).a(true);
        thien_di.b().i = new thien_el(this);
    }

    static void a(thien_eh thien_eh2, String string) {
        thien_eh2.K = string;
    }
}
