package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_z
extends thien_ac {
    public String[] a;
    private int c;
    private int d = 0;
    public thien_ae b;
    private String e = "";

    public thien_z(String[] stringArray, int n, int n2, int n3, int n4) {
        this.a = stringArray;
        this.q = n;
        this.r = n2;
        this.s = n3;
        this.t = n4;
        this.g();
    }

    public final int a() {
        return this.c;
    }

    public final void c(int n) {
        this.c = n;
        this.g();
    }

    public final boolean a(int n) {
        if (n == 14) {
            this.c();
            return false;
        }
        if (n == 15) {
            this.d();
            return false;
        }
        return true;
    }

    private void c() {
        --this.c;
        if (this.c < 0) {
            this.c = this.a.length - 1;
        }
        if (this.b != null) {
            this.b.a();
        }
        this.g();
    }

    private void d() {
        ++this.c;
        if (this.c >= this.a.length) {
            this.c = 0;
        }
        if (this.b != null) {
            this.b.a();
        }
        this.g();
    }

    public final boolean b(int n) {
        if (this.a.length == 0) {
            return true;
        }
        if (n == 14) {
            this.c();
            return false;
        }
        if (n == 15) {
            this.d();
            return false;
        }
        return true;
    }

    public final void b(int n, int n2) {
        this.v.c(this);
        ++this.c;
        if (this.c >= this.a.length) {
            this.c = 0;
        }
        if (this.b != null) {
            this.b.a();
        }
        this.g();
    }

    private void g() {
        if (this.a.length != 0) {
            this.e = thien_w.a(this.a[this.c], this.s - 35, thien_w.j);
        }
    }

    public final void a(Graphics graphics) {
        boolean bl = this.j();
        if (bl) {
            graphics.setColor(2580);
            graphics.fillRect(this.q + 2, this.r + 2, this.s - 3, this.t - 3);
        }
        int n = this.r + 3 + (thien_w.a ? 0 : 1);
        graphics.setColor(0xFFFFFF);
        if (this.a.length == 0) {
            thien_w.a(thien_w.d).a(TextConstant.noItem(), this.q + (this.s >> 1), n, 2, graphics, thien_w.j, thien_w.f);
        } else {
            thien_w.a(thien_w.d).a(this.e, this.q + (this.s >> 1), n, 2, graphics, thien_w.j, thien_w.f);
        }
        n = this.t - 2;
        int n2 = this.r + 1;
        graphics.setColor(bl ? 14675958 : 9478569);
        thien_v.a(graphics, this.q + 1, n2, this.s - 2, n);
        n = this.r + (this.t >> 1);
        graphics.drawImage(thien_b.b[2], this.q + 9, n, 3);
        graphics.drawImage(thien_b.b[3], this.q + this.s - 9, n, 3);
    }

    public final void a(thien_ae thien_ae2) {
        this.b = thien_ae2;
        if (this.y != null) {
            this.y.b = thien_ae2;
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

    public final String b() {
        if (this.c < 0 || this.c >= this.a.length) {
            return null;
        }
        return this.a[this.c];
    }

    public final void a(String string) {
        int n = 0;
        while (n < this.a.length) {
            if (this.a[n].equals(string)) {
                this.c = n;
                return;
            }
            ++n;
        }
    }
}
