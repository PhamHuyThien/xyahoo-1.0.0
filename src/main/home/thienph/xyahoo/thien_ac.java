package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public abstract class thien_ac {
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public thien_an v;
    public thien_ab w;
    public thien_ab x;
    public thien_ab y;
    int z = -1;
    public boolean A = false;

    public thien_ac() {
        this.o = true;
    }

    public thien_ac(int n, int n2, int n3, int n4, boolean bl) {
        this.q = n;
        this.r = n2;
        this.s = n3;
        this.t = n4;
        this.o = true;
    }

    public final boolean j() {
        if (this.v == null) {
            return false;
        }
        return this.v.d(this);
    }

    public final void a(int n, int n2, int n3, int n4) {
        this.q = n;
        this.r = n2;
        this.s = n3;
        this.t = n4;
    }

    public abstract void a(Graphics var1);

    public abstract void e();

    public abstract boolean b(int var1);

    public void b(Graphics graphics) {
    }

    public abstract boolean a(int var1);

    public void f() {
    }

    public void c(Graphics graphics) {
    }

    public void b(int n, int n2) {
    }

    public void c(int n, int n2) {
    }

    public void a(int n, int n2) {
    }
}
