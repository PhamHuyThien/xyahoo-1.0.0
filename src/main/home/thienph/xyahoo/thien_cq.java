package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class thien_cq extends thien_ap
{
    thien_at D;
    thien_at E;
    thien_at F;
    private Vector I;
    thien_am G;
    public static thien_ab H;
    private int J;
    private static thien_ap K;
    
    static {
        thien_cq.H = new thien_ab("G\u1ecdi 0969728701", new thien_cr());
    }
    
    public final void a(final Graphics graphics) {
        super.a(graphics);
        thien_w.a(thien_w.d).a(thien_di.b, this.J, thien_an.f - 2 - thien_w.f, graphics);
    }
    
    public thien_cq() {
        this.J = thien_an.e - thien_w.a(thien_di.b, thien_w.j) - 5;
        final thien_at f;
        (f = new thien_at("", 250, 0)).b = false;
        f.a(0, thien_an.f - thien_di.g - (thien_w.f << 1) + 5, thien_an.e - 1, thien_w.f + 6);
        f.w = new thien_ab(thien_as.K(), new thien_dh(this, f));
        f.y = new thien_ab(thien_as.t(), new thien_cs(this, f));
        this.F = f;
        final Vector vector;
        (vector = new Vector()).addElement(thien_ca.I);
        vector.addElement(new thien_ab(thien_as.e(), new thien_da(this)));
        vector.addElement(thien_cq.H);
        final thien_ab obj;
        (obj = new thien_ab(thien_as.c(), null)).c = new thien_am(vector);
        final String b = Xuka.b();
        final String c = Xuka.c();
        super.m = new thien_ab(thien_as.H(), new thien_db(this));
        super.g = " X Yahoo! ";
        thien_ap.e(70, 150);
        super.x = thien_an.f - (thien_w.i * 3 + thien_aq.a + ((thien_d.k > 170) ? 55 : 20) + thien_di.g) >> 1;
        thien_y.a(this, thien_aq.c(), false);
        super.x += ((thien_d.k > 170) ? 18 : 7);
        this.D = thien_y.a(this, "T\u00ean: ", 0, -1);
        super.x += 5;
        this.E = thien_y.a(this, String.valueOf(thien_as.G()) + ":", 2, -1);
        this.D.g = -5;
        this.E.g = -5;
        if (thien_d.k > 170) {
            super.x += 10;
            super.w = thien_ap.z;
            thien_y.a(thien_as.d(), this, -1, 16777215, false, false);
        }
        this.c(this.D);
        (this.I = new Vector()).addElement(new thien_ab(thien_as.aa(), new thien_dc(this)));
        this.I.addElement(new thien_ab(thien_as.aT(), new thien_dd(this)));
        this.I.addElement(obj);
        this.I.addElement(new thien_ab(thien_as.L(), new thien_de(this)));
        this.I.addElement(new thien_ab(thien_as.K(), new thien_df(this)));
        this.G = new thien_am(this.I);
        super.k = new thien_ab("Menu", new thien_dg(this));
        if (b != null) {
            this.D.a(b);
        }
        if (c != null) {
            this.E.a(c);
        }
        if (b != null && b.length() > 0 && c != null && c.length() > 0 && thien_di.r) {
            super.m.b.a();
        }
    }
    
    public static void f() {
        if (thien_cq.K == null) {
            System.gc();
            (thien_cq.K = new thien_ap()).g = thien_as.L();
            final thien_ap k = thien_cq.K;
            k.x += 20;
            final thien_z a = thien_y.a(thien_cq.K, thien_as.bs(), new String[] { "1", "2", "3", "4", "5", "6", "7" });
            final thien_x a2 = thien_y.a(thien_cq.K, thien_as.bt(), (thien_ae)null);
            final thien_x a3 = thien_y.a(thien_cq.K, thien_as.bu(), (thien_ae)null);
            final thien_x a4 = thien_y.a(thien_cq.K, thien_as.a(), (thien_ae)null);
            final thien_x a5 = thien_y.a(thien_cq.K, String.valueOf(thien_as.a()) + " Yahoo!", (thien_ae)null);
            final thien_v a6 = thien_y.a(thien_cq.K, "X\u00f3a d\u1eef li\u1ec7u c\u00e1 nh\u00e2n", 0, new thien_ct(), thien_cq.K.w, thien_cq.K.x + 5, 0);
            a6.q = thien_an.e - a6.s >> 1;
            a3.a = thien_di.q;
            a2.a = !thien_di.p;
            a4.a = thien_di.r;
            a5.a = thien_di.s;
            a.c(thien_at.c);
            thien_cq.K.c(a);
            thien_cq.K.k = new thien_ab(thien_as.ae(), new thien_cu(a3, a3.a, a2, a2.a, a4, a4.a, a5, a5.a, a, a.a()));
            thien_cq.K.m = new thien_ab(thien_as.u(), new thien_cv(a4, a5, a, a3, a2));
        }
        thien_di.b().b(thien_cq.K);
        thien_cq.K.a(-1);
        thien_di.b().j();
    }
    
    public final void g() {
        thien_di.c.c();
        thien_di.c.a(String.valueOf(thien_as.aV()) + thien_di.D + this.D.c() + Xuka.f + " => " + thien_di.c.w().substring(6), new thien_cw(this));
    }
    
    public final void h() {
        thien_d.b();
        if (this.D.c().equals("")) {
            this.c(this.D);
            return;
        }
        if (this.E.c().equals("")) {
            this.c(this.E);
            return;
        }
        thien_a.i(Xuka.b);
        thien_a.b();
        thien_di.b().a(String.valueOf(thien_as.J()) + this.D.c(), null, null, new thien_ab(thien_as.z(), new thien_cy(this))).a(true);
        thien_di.b().d();
        thien_di.b().i = new thien_cz(this);
    }
    
    static void a(thien_cq thien_cq) {
        if ((thien_cq = thien_cq).F != null) {
            thien_cq.b(thien_cq.F);
        }
    }
    
    static thien_ap i() {
        return thien_cq.K;
    }
}
