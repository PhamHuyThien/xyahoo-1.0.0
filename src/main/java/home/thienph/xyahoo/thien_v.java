package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_v
extends thien_ac {
    private String b;
    private int c;
    public thien_ae a;
    private static int d;
    private static int e;
    private static int f;
    private static int g;

    public thien_v() {
    }

    public thien_v(String string, int n, int n2, int n3, int n4) {
        this.c = 0;
        this.b = string;
        this.q = n;
        this.r = n2;
        this.s = n3;
        this.t = n4;
        this.y = new thien_ab(thien_as.P(), null);
    }

    public final boolean b(int n) {
        if (n == 16) {
            this.c = 2;
            return false;
        }
        return true;
    }

    public final void b(int n, int n2) {
        if (this.j()) {
            this.a.a();
            return;
        }
        this.v.c(this);
    }

    public final void a(Graphics graphics) {
        boolean bl = this.j();
        graphics.setColor(bl ? 11918844 : 1124399);
        graphics.fillRect(this.q + 2, this.r + 2, this.s - 3, this.t - 3 >> 1);
        graphics.setColor(bl ? 9291764 : 728097);
        graphics.fillRect(this.q + 2, this.r + 1 + (this.t - 3 >> 1), this.s - 3, 2 + (this.t - 3 >> 1));
        graphics.setColor(bl ? 0 : 0xFFFFFF);
        thien_w.a(bl ? thien_w.c : thien_w.d).a(this.b, this.q + (this.s >> 1), this.r + 3, 2, graphics, thien_w.j, thien_w.f);
        graphics.setColor(bl ? 14675958 : 9478569);
        thien_v.a(graphics, this.q + 1, this.r + 1, this.s - 2, this.t - 2);
    }

    public final void e() {
        if (this.c > 0) {
            --this.c;
            if (this.c == 0 && this.a != null) {
                this.a.a();
            }
        }
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4) {
        e = n + ++n3 - 2;
        g = n2 + ++n4 - 2;
        f = n + 1;
        graphics.fillRect(f, g, 1, 1);
        graphics.fillRect(e, g, 1, 1);
        g = n2 + 1;
        graphics.fillRect(f, g, 1, 1);
        graphics.fillRect(e, g, 1, 1);
        d = n4 - 4;
        e = n2 + 2;
        graphics.fillRect(n, e, 1, d);
        graphics.fillRect(n + n3 - 1, e, 1, d);
        d = n + 2;
        e = n3 - 4;
        graphics.fillRect(d, n2, e, 1);
        graphics.fillRect(d, n2 + n4 - 1, e, 1);
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4, int n5) {
        graphics.setColor(11320516);
        graphics.fillRoundRect(n, n2, n3, n4, 8, 8);
        graphics.setColor(2580);
        graphics.fillRoundRect(n + 1, n2 + 1, n3 - 2, n4 - 2, 8, 8);
    }

    public final boolean a(int n) {
        return true;
    }
}
