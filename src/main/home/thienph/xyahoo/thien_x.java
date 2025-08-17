package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_x
extends thien_ac {
    private String c;
    private int d;
    public boolean a;
    public thien_ae b;

    public thien_x(String string, int n, int n2, int n3, int n4) {
        this.c = string;
        this.q = n;
        this.r = n2;
        this.s = n3;
        this.t = n4;
        this.x = new thien_ab(thien_as.P(), null);
    }

    public final boolean a(int n) {
        return this.b(n);
    }

    public final boolean b(int n) {
        if (n == 18) {
            this.d = 2;
            return false;
        }
        return true;
    }

    private void a() {
        boolean bl = this.a = !this.a;
        if (this.b != null) {
            this.b.a();
        }
    }

    public final void b(int n, int n2) {
        this.v.c(this);
        this.a();
    }

    public final void e() {
        if (this.d > 0) {
            --this.d;
            if (this.d == 0) {
                this.a();
            }
        }
    }

    public final void a(Graphics graphics) {
        boolean bl = this.j();
        graphics.drawImage(this.a ? thien_di.y[1] : thien_di.y[0], this.q + 8, this.r + (this.t >> 1) + 1, 3);
        if (bl) {
            graphics.setColor(14675958);
            graphics.drawRoundRect(this.q + 13 + 4, this.r + 1, this.s - 13, this.t, 5, 5);
        }
        graphics.setColor(0xFFFFFF);
        thien_w.a(thien_w.d).a(this.c, this.q + 13 + 5, this.r + 3, graphics);
    }

    public final void b(Graphics graphics) {
    }
}
