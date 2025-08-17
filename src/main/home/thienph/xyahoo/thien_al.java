package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_al
extends thien_ac {
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    public int a;
    public thien_ab b;
    private thien_ab m;
    private int n;
    private thien_s B;
    public Vector c;
    private thien_u C;
    public thien_ae d;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private boolean L;
    private int M;
    private int N;

    public final void a(thien_s thien_s2, int n) {
        this.B = thien_s2;
        this.a = 0;
        this.a();
        this.f();
    }

    public thien_al(int n, int n2, int n3, int n4, int n5) {
        super(1, 1, n3, n4, true);
        new Vector();
        this.b = new thien_ab(thien_as.P(), null);
        this.m = new thien_ab("", null);
        (new String[1])[0] = thien_as.au();
        System.currentTimeMillis();
        this.n = 0;
        this.p = true;
        this.j = thien_w.f + 3;
        if (this.j < thien_b.a[0].getHeight()) {
            this.j = thien_b.a[0].getHeight();
        }
        this.D = n3 - 51;
        this.E = 1;
        this.F = 50;
        this.G = 120;
        this.K = n3 / 2;
    }

    private void a() {
        this.c = new Vector();
        if (this.B == null || this.B.a == null || this.B.a.size() == 0) {
            this.k = 0;
            this.l = 0;
            this.i = 0;
            return;
        }
        Vector vector = this.B.a;
        int n = vector.size();
        boolean bl = false;
        int n2 = 0;
        while (n2 < n) {
            block12: {
                Object object;
                thien_t thien_t2;
                block11: {
                    thien_t2 = (thien_t)vector.elementAt(n2);
                    object = new thien_u();
                    new thien_u().d = thien_t2.a();
                    if (((thien_u)object).d == null || ((thien_u)object).d.length() <= 0) break block11;
                    ((thien_u)object).a = 1;
                    ((thien_u)object).g = thien_t2.b();
                    this.c.addElement(object);
                    if (((thien_u)object).g == 1) break block12;
                }
                object = thien_t2.a;
                int n3 = ((Vector)object).size();
                int n4 = 0;
                while (n4 < n3) {
                    thien_r thien_r2 = (thien_r)((Vector)object).elementAt(n4);
                    thien_u thien_u2 = new thien_u();
                    new thien_u().j = thien_r2.f;
                    thien_u2.d = thien_r2.a;
                    thien_u2.g = thien_r2.c;
                    thien_u2.e = thien_r2.b;
                    thien_u2.b = thien_r2.a();
                    thien_u2.c = thien_r2.j;
                    thien_u2.c = new Integer(thien_r2.a());
                    thien_u2.h = thien_r2.e;
                    thien_u2.f = thien_r2.d;
                    thien_u2.i = thien_r2;
                    this.c.addElement(thien_u2);
                    ++n4;
                }
            }
            ++n2;
        }
        if (this.a < 0) {
            this.a = 0;
        }
        if (this.a >= this.c.size()) {
            this.a = this.c.size() - 1;
        }
        this.l = this.t / this.j + 1;
        this.i = this.c.size() * this.j - this.t + 3 + this.j;
        this.e = this.a * this.j - (this.t >> 1);
        this.k = this.a - (this.l >> 1);
        if (this.c.size() - this.a < this.l >> 1) {
            this.k = this.c.size() - this.l;
        }
        if (this.k < 0) {
            this.k = 0;
        }
        if (((thien_u)this.c.elementAt((int)this.a)).a == 1) {
            this.y = this.m;
            return;
        }
        this.y = this.b;
    }

    public final boolean a(int n) {
        if (n == 13 || n == 12) {
            this.b(n);
            return false;
        }
        return true;
    }

    public final boolean b(int n) {
        if (this.c == null || this.c.size() == 0) {
            return true;
        }
        if (n == 12) {
            System.currentTimeMillis();
            --this.a;
            if (this.a < 0) {
                this.a = this.c.size() - 1;
            }
        }
        if (n == 13) {
            System.currentTimeMillis();
            ++this.a;
            if (this.a >= this.c.size()) {
                this.a = 0;
            }
        }
        if (n == 12 || n == 13) {
            this.y = ((thien_u)this.c.elementAt((int)this.a)).a == 1 ? this.m : this.b;
            this.e = this.a * this.j - (this.t >> 1);
            this.k = this.a - (this.l >> 1);
            if (this.c.size() - this.a < this.l >> 1) {
                this.k = this.c.size() - this.l;
            }
            if (this.k < 0) {
                this.k = 0;
            }
            thien_d.b();
            if (thien_ar.a) {
                thien_ar.a(true);
            }
        }
        if (n == 16) {
            this.b();
            thien_d.b();
        }
        return true;
    }

    private void b() {
        if (this.a == -1) {
            return;
        }
        this.C = (thien_u)this.c.elementAt(this.a);
        if (this.C.a == 0) {
            if (this.d != null) {
                this.d.a();
                return;
            }
        } else {
            if (this.C.g == 0) {
                this.B.a(this.C.d, 1);
            } else {
                this.B.a(this.C.d, 0);
            }
            this.a();
        }
    }

    public final void a(Graphics graphics) {
        this.H = this.s >> 1;
        graphics.setClip(this.q, this.r, this.s + 1, this.t);
        graphics.translate(2, 2);
        graphics.translate(0, -this.h);
        int n = this.k * this.j;
        this.H = this.k + this.l;
        this.I = this.c.size();
        this.J = this.j + 2;
        int n2 = 0;
        int n3 = this.s - 3;
        int n4 = this.k;
        while (n4 <= this.H) {
            String string;
            int n5;
            if (n4 >= this.I) break;
            thien_u thien_u2 = (thien_u)this.c.elementAt(n4);
            n2 = this.j;
            if (n4 == this.a) {
                if (this.n == 1 && thien_u2.a == 0 && !thien_u2.e.equals("")) {
                    n2 <<= 1;
                }
                graphics.setColor(2580);
                graphics.fillRect(1, n + 1, n3, n2);
                graphics.setColor(9478569);
                graphics.drawRoundRect(0, n + 1, n3 + 1, n2, 5, 5);
                if (n2 > this.j && thien_u2.f != null) {
                    graphics.setColor(3981823);
                    thien_w.a(thien_w.e).a(thien_u2.f, 22, n + this.J, graphics);
                }
            }
            graphics.setColor(0);
            if (thien_u2.a == 1) {
                n5 = 18;
                graphics.drawImage(thien_b.b[thien_u2.g], 9, n + (this.j >> 1) + 1, 3);
            } else {
                n5 = 22;
                graphics.drawImage(thien_b.a[thien_u2.g], 11, n + (this.j >> 1) + 2, 3);
            }
            if (thien_u2.a == 1) {
                string = thien_u2.d;
                string = thien_w.a(string, this.s - 26, thien_w.j);
                graphics.setColor(16726823);
                thien_w.a(thien_w.b).a(string, n5, n + 2, graphics);
            } else {
                string = thien_u2.e;
                if (string != null) {
                    string = thien_w.a(string, this.s - 26, thien_w.j);
                    graphics.setColor(thien_u2.b);
                    thien_w.a(thien_u2.c).a(string, n5, n + 3, graphics);
                }
            }
            n += n2;
            ++n4;
        }
        graphics.translate(0, this.h);
        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
        graphics.setClip(-1000, -1000, 2000, 2000);
    }

    public final void b(Graphics graphics) {
    }

    public final void e() {
        thien_al thien_al2 = this;
        if (thien_al2.h != thien_al2.e) {
            thien_al2.f = thien_al2.e - thien_al2.h << 2;
            thien_al2.g += thien_al2.f;
            thien_al2.h += thien_al2.g >> 4;
            thien_al2.g &= 0xF;
            if (thien_al2.h > thien_al2.i) {
                thien_al2.h = thien_al2.i;
            }
            if (thien_al2.h < 0) {
                thien_al2.h = 0;
            }
            thien_al2.k = thien_al2.h / thien_al2.j - 1;
            if (thien_al2.k < 0) {
                thien_al2.k = 0;
            }
        }
    }

    public final void f() {
        if (this.c == null) {
            return;
        }
        if (this.r + this.c.size() * this.j >= this.t) {
            thien_ar.a = true;
            thien_ar.a(this.c.size());
            return;
        }
        thien_ar.a = false;
    }

    public final void c(Graphics graphics) {
        if (thien_ar.a) {
            thien_ar.a(graphics, this.a);
        }
    }

    public final void a(int n, int n2) {
        this.M = n;
        this.N = n2;
    }

    public final void b(int n, int n2) {
        if (this.L) {
            this.L = false;
            this.e -= (n2 - this.N) * 5;
            if (this.e < 0) {
                this.e = 0;
            } else if (this.e > this.i) {
                this.e = this.i;
            }
        } else {
            n = (n2 + this.h) / this.j;
            if (n < 0) {
                n = 0;
            }
            if (n > this.c.size() - 1) {
                n = this.c.size() - 1;
            }
            if (n < 0) {
                return;
            }
            if (this.a == n) {
                this.b();
                return;
            }
            if (this.a > n) {
                this.a = n;
            } else if (this.n == 0) {
                this.a = n;
            } else {
                thien_u thien_u2 = (thien_u)this.c.elementAt(this.a);
                if (thien_u2.e == null || thien_u2.e.equals("")) {
                    this.a = n;
                } else {
                    if (this.a == n - 1) {
                        this.b();
                        return;
                    }
                    this.a = n - 1;
                }
            }
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void c(int n, int n2) {
        if (thien_b.c(n - this.M) > 1 || thien_b.c(n2 - this.N) > 1) {
            this.L = true;
            this.e -= n2 - this.N;
            if (this.e < 0) {
                this.e = 0;
            } else if (this.e > this.i) {
                this.e = this.i;
            }
            this.h = this.e;
            this.k = this.h / this.j - 1;
            if (this.k < 0) {
                this.k = 0;
            }
            this.M = n;
            this.N = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }
}
