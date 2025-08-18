package home.thienph.xyahoo;

import java.util.Vector;

public class thien_ap
extends thien_an {
    public int w;
    public int x;
    public int y;
    private thien_ao[] D;
    private int E = -1;
    private Vector F = new Vector();
    public static int z;
    public static int A;
    public static int B;
    public static int C;

    public thien_ap() {
        this.e();
    }

    public final void e() {
        this.y = thien_an.e - 30;
        if (this.y < 100) {
            this.y = 100;
        }
        if (this.y > 180) {
            this.y = 180;
        }
        this.w = thien_an.e - this.y >> 1;
        this.x = 5;
    }

    public static void e(int n, int n2) {
        C = thien_an.e * 6 / 10;
        if (C > 150) {
            C = 150;
        }
        if ((B = thien_an.e - C - 15) > 70) {
            B = 70;
        }
        z = thien_an.e - (C + B + 5) >> 1;
        A = z + B + 5;
    }

    public final void a(thien_ac thien_ac2, boolean bl) {
        if (this.F.contains(thien_ac2)) {
            return;
        }
        thien_ac2.v = this;
        this.F.addElement(thien_ac2);
        this.j.addElement(thien_ac2);
        if (bl) {
            this.x = thien_ac2.r + thien_ac2.t + 2;
        }
    }

    public final void a(thien_ac thien_ac2) {
        if (this.F.contains(thien_ac2)) {
            return;
        }
        thien_ac2.v = this;
        this.F.addElement(thien_ac2);
        this.j.addElement(thien_ac2);
        this.x = thien_ac2.r + thien_ac2.t + 2;
    }

    public final void b(thien_ac thien_ac2) {
        this.F.removeElement(thien_ac2);
        super.b(thien_ac2);
    }

    public final void a() {
        this.F.removeAllElements();
        super.a();
    }

    public final void a(String[] stringArray) {
        int n = stringArray.length;
        this.D = new thien_ao[n];
        int n2 = 0;
        while (n2 < n) {
            this.D[n2] = new thien_ao(stringArray[n2], 0, 0, thien_an.e - 1, thien_w.f + 2);
            this.D[n2].a = this;
            this.D[n2].b = n2;
            ++n2;
        }
    }

    public final void d(int n) {
        if (this.E != -1) {
            this.D[this.E].c = false;
        }
        if (this.E == n) {
            this.E = -1;
        } else {
            this.E = n;
            this.D[this.E].c = true;
        }
        thien_ap thien_ap2 = this;
        super.a();
        int n2 = 10;
        int n3 = 0;
        int n4 = thien_ap2.F.size();
        int n5 = 0;
        while (n5 < n4) {
            thien_ac thien_ac2 = (thien_ac)thien_ap2.F.elementAt(n5);
            if (thien_ac2.z == -1) {
                if (n2 < thien_ac2.r + thien_ac2.t) {
                    n2 = thien_ac2.r + thien_ac2.t;
                }
                super.a(thien_ac2);
            } else {
                if (n3 == thien_ac2.z) {
                    if (thien_ap2.j.size() > 0 && !(thien_ap2.j.lastElement() instanceof thien_ao)) {
                        n2 += 10;
                    }
                    thien_ap2.D[n3].r = n2;
                    super.a(thien_ap2.D[n3]);
                    if (thien_ap2.E == thien_ac2.z) {
                        thien_ap2.c(thien_ap2.D[n3]);
                    }
                    n2 += thien_ap2.D[n3].t;
                    ++n3;
                }
                if (thien_ap2.E == thien_ac2.z) {
                    if (thien_ac2 instanceof thien_v) {
                        // empty if block
                    }
                    thien_ac2.r = ++n2;
                    super.a(thien_ac2);
                    n2 += thien_ac2.t;
                    if (thien_ac2 instanceof thien_at) {
                        n2 += 5;
                    }
                }
            }
            ++n5;
        }
        thien_ap2.b();
        thien_ap2.r = thien_ap2.q;
        thien_ap2.d();
    }

    public final thien_ac c(int n) {
        int n2 = this.F.size();
        int n3 = 0;
        while (n3 < n2) {
            thien_ac thien_ac2 = (thien_ac)this.F.elementAt(n3);
            if (thien_ac2.u == n) {
                return thien_ac2;
            }
            ++n3;
        }
        return null;
    }
}
