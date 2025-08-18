package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_aj
extends thien_ac {
    private String[] c;
    public Integer a;
    private int d;
    public thien_ae b;
    private int e;
    private int f;
    private int g;

    public thien_aj() {
    }

    public thien_aj(final String s, final int q, final int r, final int s2, final int e) {
        this.d = 0;
        this.c = thien_w.c(s, thien_an.e - q, thien_w.j);
        this.a = thien_w.e;
        String[] c;
        for (int a = thien_w.a((c = this.c)[0], thien_w.j), i = 1; i < c.length; ++i) {
            final int a2 = thien_w.a(c[i], thien_w.j);
            if (a < a2) {
                a = a2;
            }
        }
        super.q = q;
        super.r = r;
        super.s = s2;
        this.e = e;
        super.t = e * this.c.length;
        super.y = new thien_ab(thien_as.P(), null);
        this.f = (e >> 1) + 2;
        this.g = (e - thien_w.f >> 1) + 1;
    }

    public final boolean b(int n) {
        if (n == 16) {
            this.d = 2;
            return false;
        }
        return true;
    }

    public final void b(int n, int n2) {
        if (this.j()) {
            this.b.a();
            return;
        }
        this.v.c(this);
    }

    public final void a(Graphics graphics) {
        boolean bl = this.j();
        int n = this.q;
        graphics.setColor(this.a.intValue());
        int n2 = 0;
        while (n2 < this.c.length) {
            thien_w.a(this.a).a(this.c[n2], n + 2, this.r + this.e * n2 + this.g, graphics);
            if (bl) {
                graphics.setColor(8111862);
                graphics.fillRect(n + 2, this.r + this.e * n2 + this.e - (thien_w.a ? 1 : 3), thien_w.a(this.c[n2], thien_w.j) + 2, 1);
            }
            ++n2;
        }
    }

    public final void e() {
        if (this.d > 0) {
            --this.d;
            if (this.d == 0 && this.b != null) {
                this.b.a();
            }
        }
    }

    public final void b(Graphics graphics) {
    }

    public final boolean a(int n) {
        return true;
    }
}
