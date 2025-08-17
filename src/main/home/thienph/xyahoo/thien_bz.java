package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class thien_bz extends thien_ac
{
    public String a;
    public long b;
    public int c;
    private boolean H;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public byte[] i;
    public boolean j;
    public byte k;
    public boolean l;
    private String I;
    private boolean J;
    private String K;
    public boolean m;
    public byte n;
    public int B;
    public String C;
    public int D;
    public Integer E;
    public int F;
    private int L;
    private int M;
    private int N;
    private long O;
    boolean G;
    private int P;
    private long Q;
    
    static {
        final int e = thien_an.e;
        final int f = thien_an.f;
        final int b = thien_an.b;
        final int f2 = thien_di.f;
    }
    
    public thien_bz() {
        this.d = "";
        this.K = "";
        this.M = 20;
        this.N = 32;
        this.j = false;
        new Vector();
        new Vector();
        new Vector();
    }
    
    public thien_bz(final String a, final long b, final int n, final int c, final boolean h, final String c2, final int d, final Integer e) {
        this.d = "";
        this.K = "";
        this.M = 20;
        this.N = 32;
        this.j = false;
        this.H = h;
        if (a == null) {
            this.a = "";
        }
        else {
            this.a = a;
        }
        this.c = c;
        this.b = b;
        this.k = (byte)n;
        if (this.c == -1) {
            final Image[] a2 = thien_b.a;
        }
        final int n2 = thien_an.f - thien_di.f - 40 - ((32 > thien_w.f << 1) ? 32 : (thien_w.f << 1)) - 5;
        if (n % 2 == 0) {
            this.e = (thien_an.e >> 1) - 10;
            this.L = 6;
            this.f = ((n == 0) ? n2 : thien_w.f);
        }
        else {
            this.f = n2 >> 1;
            this.L = 20;
            this.e = ((n == 1) ? (thien_an.e - thien_w.a("100000 " + a(), thien_w.j)) : 10);
        }
        this.I = thien_w.a(this.a, 9);
        this.C = c2;
        this.D = d;
        this.E = e;
    }
    
    private static String a() {
        if (thien_ba.S.R) {
            return "gold";
        }
        return "xuxu";
    }
    
    public final void a(final Graphics graphics, final int n, int n2) {
        if (5 - (byte)(System.currentTimeMillis() / 1000L - this.n) > 0) {
            final int n3 = n2 - 10;
            n2 = n;
            graphics.setColor(14545919);
            graphics.drawRoundRect(n2 - 4, n3 - 4, 26, 26, 5, 5);
            graphics.setColor(872315);
            graphics.fillTriangle(n2 - 3, n3 - 3, n2 + 10, n3 + 30, n2 + 13, n3 - 3);
            graphics.setColor(14545919);
            graphics.drawLine(n2 - 3, n3 - 3, n2 + 10, n3 + 30);
            graphics.drawLine(n2 + 10, n3 + 30, n2 + 13, n3 - 3);
            graphics.setColor(872315);
            graphics.fillRoundRect(n2 - 3, n3 - 3, 25, 25, 5, 5);
            graphics.drawRegion(thien_di.u, this.B * 18, 0, 18, 18, 0, n2, n3, 20);
            graphics.setColor(0);
            return;
        }
        this.m = false;
    }
    
    private void b(final Graphics graphics, final int n, final int n2) {
        if (thien_ba.S.R && this.C != null) {
            graphics.setColor(((Integer)this.E).intValue());
            thien_w.a(this.E).a(this.C, n, n2, 2, graphics, thien_w.j, thien_w.f);
            thien_w.a(this.E).a(String.valueOf(this.D) + "\u0111", n, n2 + 13, 2, graphics, thien_w.j, thien_w.f);
        }
    }
    
    public final void a(final Graphics graphics) {
        if (this.a != null && !this.j) {
            graphics.drawImage(thien_ba.aj[this.F], this.e, this.f, this.L);
            graphics.setColor(16777215);
            thien_w.a(thien_w.d).a(String.valueOf(thien_as.bA()) + ": " + thien_ba.S.C + " " + a(), 5, 2 - thien_w.f, graphics);
            if (!thien_ba.S.E) {
                if (this.H) {
                    this.d = thien_as.l();
                }
                else if (this.g) {
                    this.d = thien_as.bz();
                }
                else {
                    this.d = "";
                }
                if (this.m) {
                    this.a(graphics, this.e, this.f - 20);
                }
            }
            else if (!this.h) {
                this.d = "";
            }
            graphics.setColor(16777215);
            if (this.k == 1 || this.k == 3) {
                thien_w.a(thien_w.d).a(this.d, this.e, this.f - 15, graphics);
                this.b(graphics, this.e + 20, this.f - 45);
            }
            else {
                thien_w.a(thien_w.d).a(this.d, this.e - 64, this.f - 10, graphics);
                this.b(graphics, this.e - 30, this.f + 5);
            }
            if (this.l) {
                if (this.k == 1 || this.k == 3) {
                    graphics.drawImage(thien_by.k, this.e + (this.M >> 1), this.f - 2, 33);
                }
                else {
                    graphics.drawImage(thien_by.k, this.e - 13, this.f, 0);
                }
            }
            graphics.setColor(16777215);
            if (this.k == 1 || this.k == 3) {
                thien_w.a(thien_w.d).a(this.I, this.e, this.f + this.N, graphics);
                thien_w.a(thien_w.d).a(String.valueOf(this.b) + " " + a(), this.e, this.f + this.N + thien_w.f, graphics);
            }
            else {
                thien_w.a(thien_w.d).a(this.I, this.e + 7 + this.M, this.f - 7, graphics);
                thien_w.a(thien_w.d).a(String.valueOf(this.b) + " " + a(), this.e + 7 + this.M, this.f + 7, graphics);
            }
            if (this.G && this.P >= 0) {
                graphics.setColor(16726823);
                if (this.k == 1 || this.k == 3) {
                    thien_ba.S.l.a = "";
                    thien_ba.S.m.a = "";
                    thien_w.a(thien_w.b).a(new StringBuffer(String.valueOf(this.P)).toString(), this.e + 2, this.f - 15, graphics);
                    return;
                }
                if (this.k == 2) {
                    thien_ba.S.l.a = "";
                    thien_ba.S.m.a = "";
                    thien_w.a(thien_w.b).a(new StringBuffer(String.valueOf(this.P)).toString(), this.e - 17, this.f - 5, graphics);
                    return;
                }
                thien_ba.S.l.a = thien_as.bC();
                thien_ba.S.m.a = thien_as.i();
                thien_w.a(thien_w.b).a(new StringBuffer(String.valueOf(this.P)).toString(), this.e - 17, this.f - 5, graphics);
            }
        }
    }
    
    public final void a(final boolean b) {
        this.g = false;
        this.J = false;
    }
    
    public final void c(final int n) {
        this.G = true;
        this.O = 30L;
        this.Q = System.currentTimeMillis();
    }
    
    public final boolean b(final int n) {
        return true;
    }
    
    public final void e() {
        if (this.G) {
            this.P = (int)(this.O - (int)((System.currentTimeMillis() - this.Q) / 1000L));
            if (this.P == 0) {
                this.G = false;
            }
        }
    }
    
    public final boolean a(final int n) {
        return false;
    }
}
