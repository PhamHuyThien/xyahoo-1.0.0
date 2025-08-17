package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_gp
extends thien_an {
    public thien_b w;
    public static String x;
    public static String y;
    public static int z;
    public static String A;
    private static boolean D;
    private boolean E;
    private boolean F;
    private Vector G;
    thien_am B;
    private thien_at H;
    public boolean C;
    private thien_ai I;
    private thien_at J;
    private thien_ai K;
    private thien_at L;
    private thien_x M;
    private thien_ai N;
    private thien_z O;
    private int P;
    private int Q;
    private thien_ab R;
    private thien_ab S;
    private thien_ab T;
    private int U;
    private thien_ap V;
    private thien_z W;
    private thien_at X;

    public thien_gp() {
        String string = Xuka.d();
        String string2 = Xuka.e();
        this.g = "Yahoo!";
        int n = thien_ca.D.H.a[0].getHeight();
        this.P = thien_an.e - thien_ca.D.H.a[0].getWidth() >> 1;
        int n2 = (thien_w.f + 6 << 2) + 28 + n + 5;
        this.Q = n2 <= thien_an.f - thien_di.g ? thien_di.f - 10 + (thien_an.f - thien_di.g - n2 >> 1) : thien_di.f + 5;
        n = this.Q + n - 3;
        this.I = new thien_ai("Yahoo! ID:", thien_ap.z, n, thien_w.f);
        this.I.s = thien_ap.B;
        this.J = new thien_at();
        this.J.a(thien_ap.A, n, thien_ap.C, thien_w.f + 6);
        this.J.e(0);
        this.K = new thien_ai(String.valueOf(thien_as.G()) + ":", thien_ap.z, n += this.J.t + 7, thien_w.f);
        this.K.s = thien_ap.B;
        this.L = new thien_at();
        this.L.a(thien_ap.A, n, thien_ap.C, thien_w.f + 6);
        this.L.e(2);
        this.L.a = true;
        this.J.a(string);
        this.J.g = -5;
        this.L.a(string2);
        this.L.g = -5;
        this.N = new thien_ai("Domain:", thien_ap.z, n += this.L.t + 7, thien_w.f);
        this.N.s = thien_ap.B;
        this.O = new thien_z(new String[]{"@yahoo", "@ymail", "@rocketmail"}, thien_ap.A, n, thien_ap.C, thien_w.f + 6);
        this.O.c(Xuka.f());
        int n3 = thien_an.e - (thien_w.a(thien_as.I(), thien_w.j) + 13 + 4) >> 1;
        this.M = new thien_x(thien_as.I(), n3, n += 6 + this.O.t, thien_w.a(thien_as.I(), thien_w.j) + 13 + 4, thien_w.f + 4);
        this.M.a = Xuka.b("statusYahoo", false);
        int cfr_ignored_0 = this.M.t;
        this.H = new thien_at();
        this.H.a = true;
        this.H.a(0, thien_an.f - thien_di.g - thien_w.f - 11, thien_an.e - 6, thien_w.f + 6);
        this.w = new thien_b(1, 1, thien_an.e - 3, thien_an.f - 2 - thien_di.g, true);
        this.a(this.w);
        this.c(this.w);
        this.w.c = true;
        this.w.d = Xuka.b("hideOffline", true);
        this.G = new Vector();
        this.G.addElement(new thien_ab(thien_as.ay(), new thien_gq(this)));
        this.G.addElement(new thien_ab(thien_as.ar(), new thien_gv(this)));
        this.G.addElement(new thien_ab(thien_as.aY(), new thien_gw(this)));
        this.G.addElement(new thien_ab(thien_as.aL(), new thien_gx(this)));
    }

    public final void e() {
        if (this.C || this.F) {
            this.C = false;
            thien_a.b(x, 2);
            this.a(false);
        }
        thien_di.c.c(this.V);
        this.V = null;
    }

    public final void a(boolean bl) {
        this.F = bl;
        if (bl) {
            if (this.B == null) {
                this.B = new thien_am(this.G);
                this.R = new thien_ab("Menu", new thien_gy(this));
            }
            this.k = this.R;
            this.m = null;
            this.b(this.I);
            this.b(this.J);
            this.b(this.K);
            this.b(this.L);
            this.b(this.M);
            this.b(this.N);
            this.b(this.O);
            this.a(this.w);
            this.c(this.w);
        } else {
            if (this.S == null) {
                this.S = new thien_ab(thien_as.H(), new thien_gz(this));
                this.T = new thien_ab(thien_as.ae(), new thien_gr(this));
            }
            this.m = this.S;
            this.k = this.T;
            this.i();
            this.b(this.w);
            this.a(this.I);
            this.a(this.J);
            this.a(this.K);
            this.a(this.L);
            this.a(this.N);
            this.a(this.O);
            this.a(this.M);
            this.c(this.J);
        }
        this.q = 0;
        this.r = 0;
        thien_gp thien_gp2 = this;
        thien_gp2.w.f();
        System.gc();
    }

    public final void b(Graphics graphics) {
        if (!this.F) {
            graphics.drawImage(thien_ca.D.H.a[0], this.P, this.Q, 0);
        }
        super.b(graphics);
    }

    protected final void f() {
        this.J.a(this.J.c().trim().toLowerCase());
        String string = this.J.c();
        String string2 = this.L.c();
        if (string.equals("")) {
            this.c(this.J);
            return;
        }
        if (string2.equals("")) {
            this.c(this.L);
            return;
        }
        x = string;
        y = string;
        z = this.M.a ? 12 : 0;
        D = this.M.a;
        String string3 = Xuka.c(x, true);
        A = string3 == null ? "" : string3;
        Xuka.d(string);
        Xuka.e(string2);
        int n = this.O.a();
        Xuka.a(this.O.a());
        if (n == 1 || n == 2) {
            x = String.valueOf(x) + this.O.b() + ".com";
        }
        this.w.e = true;
        this.a(true);
        thien_gp thien_gp2 = this;
        this.U = thien_di.a(true);
        if (thien_gp2.U != -1) {
            thien_s thien_s2 = thien_di.a(true, x);
            if (thien_s2 != null) {
                thien_di.c.k.w.a(thien_s2, -1);
            } else {
                thien_gp2.U = -1;
            }
        }
        thien_a.a(string, string2, z, 2, this.U);
    }

    public final void d() {
        this.w.f();
    }

    public final void d(Graphics graphics) {
        this.w.c(graphics);
    }

    public final void g() {
        if (this.w.l != null) {
            this.w.l.removeAllElements();
        }
        this.w.l = null;
        this.w.k = null;
    }

    private void i() {
        this.c(this.w);
        this.b(this.H);
        this.E = false;
    }

    public final boolean a(boolean[] blArray, boolean[] blArray2, int[] nArray) {
        Object object;
        if (nArray[0] > 32 && !this.E && this.F) {
            object = this;
            ((thien_gp)object).H.a("");
            ((thien_an)object).a(((thien_gp)object).H);
            ((thien_an)object).c(((thien_gp)object).H);
            ((thien_gp)object).E = true;
        }
        object = "";
        if (this.E) {
            if (blArray[12]) {
                blArray[12] = false;
                this.w.b(12);
            } else if (blArray[13]) {
                blArray[13] = false;
                this.w.b(13);
            } else if (blArray[16]) {
                blArray[16] = false;
                this.w.b(16);
            }
            object = this.H.c();
        }
        boolean bl = super.a(blArray, blArray2, nArray);
        if (this.E) {
            if (this.H.c().equals("")) {
                this.i();
            }
            if (!this.H.c().equals(object)) {
                this.w.d(this.H.c());
            }
        }
        return bl;
    }

    public final void h() {
        Xuka.h(x);
        thien_di.b().a(String.valueOf(thien_as.bf()) + "?", new thien_gs(this));
    }

    static void a(thien_gp thien_gp2) {
        if (D) {
            thien_di.c.a("Vui l\u00f2ng tho\u00e1t Yahoo! v\u00e0 b\u1ecf ch\u1ecdn \u0111\u0103ng nh\u1eadp \u1ea9n", (Image)null, 1);
            return;
        }
        if (thien_di.z) {
            thien_di.c.a("Vui l\u00f2ng ch\u1edd 10s", (Image)null, 1);
            return;
        }
        if (thien_gp2.V == null) {
            System.gc();
            thien_gp2.V = new thien_ap();
            thien_gp2.V.g = thien_as.ar();
            thien_ap cfr_ignored_0 = thien_gp2.V;
            thien_ap.e(70, 150);
            thien_gp2.V.x += 20;
            thien_gp2.W = thien_y.a(thien_gp2.V, thien_as.ar(), new String[]{thien_as.aQ(), thien_as.aR()});
            thien_gp2.X = thien_y.b(thien_gp2.V, thien_as.as(), 0, -1);
            thien_gp2.V.c(thien_gp2.W);
            thien_gp2.V.m = new thien_ab("OK", new thien_gt(thien_gp2));
            thien_gp2.V.k = new thien_ab(thien_as.z(), new thien_gu(thien_gp2));
        }
        thien_gp2.W.c(z == 0 ? 0 : 1);
        thien_di.b().b(thien_gp2.V);
        thien_gp2.X.a(A);
        thien_di.b().j();
    }

    static thien_at b(thien_gp thien_gp2) {
        return thien_gp2.X;
    }

    static thien_z c(thien_gp thien_gp2) {
        return thien_gp2.W;
    }

   static void a(thien_gp var0, String var1) {
      thien_a.a(var1, 2);
      A = var1;
      Xuka.a(x, var1, true);
   }

    static thien_ap d(thien_gp thien_gp2) {
        return thien_gp2.V;
    }
}
