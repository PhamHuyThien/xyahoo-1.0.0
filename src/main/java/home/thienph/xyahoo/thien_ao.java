package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ao
extends thien_ac {
    private String d;
    private int e;
    public thien_ap a;
    public int b;
    private int f;
    public boolean c;

    public thien_ao() {
    }

    public thien_ao(String string, int n, int n2, int n3, int n4) {
        this();
        this.e = 0;
        this.d = string;
        this.q = 0;
        this.r = 0;
        this.s = n3;
        this.t = n4 < 19 ? n4 : 19;
    }

    public final boolean b(int n) {
        if (n == 16) {
            this.e = 2;
            return false;
        }
        return true;
    }

    public final void b(int n, int n2) {
        this.a.d(this.b);
    }

    public final void a(Graphics graphics) {
        boolean bl = this.j();
        if (bl) {
            this.f = thien_w.a(this.d, thien_w.j);
            graphics.setColor(2580);
            graphics.fillRoundRect(this.q + 19, this.r, this.f + 10, this.t, 8, 8);
        }
        graphics.setColor(3981823);
        thien_w.a(thien_w.e).a(this.d, this.q + 23, this.r + (this.t - thien_w.f >> 1), graphics);
        graphics.drawImage(thien_b.b[this.c ? 0 : 1], this.q + 10, this.r + (this.t >> 1), 3);
    }

    public final void e() {
        if (this.e > 0) {
            --this.e;
            if (this.e == 0) {
                this.a.d(this.b);
            }
        }
    }

    public final void b(Graphics graphics) {
    }

    public final boolean a(int n) {
        return true;
    }
}
