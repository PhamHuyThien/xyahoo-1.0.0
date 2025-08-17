package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_by {
    public static int a = 40;
    public static int b = 54;
    public byte c;
    public byte d;
    public byte e;
    private static Image[] m;
    private static Image[] n;
    private static Image[] o;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    private static int p;
    private static int q;
    private static int r;
    private static int s;
    private static int t;
    private static int u;
    private static int v;
    private static int w;
    private static Image x;
    private static Image y;
    public static Image k;
    public static Image l;

    static {
        p = 12;
        q = 16;
        r = 12;
        s = 38;
        t = 6;
        u = 8;
        v = 6;
        w = 21;
    }

    public static byte[] a(thien_by[] thien_byArray) {
        int n = thien_byArray.length;
        byte[] byArray = new byte[n];
        while (--n >= 0) {
            byArray[n] = thien_byArray[n].c;
        }
        return byArray;
    }

    public static byte[] a(byte[] byArray) {
        int n = byArray.length;
        byte[] byArray2 = new byte[n];
        while (--n >= 0) {
            byte by = byArray[n];
            byArray2[n] = (byte)(by >> 2);
        }
        return byArray2;
    }

    public static byte a(byte by) {
        return (byte)(by >> 2);
    }

    public static int a(int n) {
        return n % 4;
    }

    public static boolean a(int n, int n2) {
        block3: {
            block2: {
                int n3 = n;
                if (n3 % 4 + (n3 = n2) % 4 == 1) break block2;
                n3 = n;
                if (n3 % 4 + (n3 = n2) % 4 != 5) break block3;
            }
            return true;
        }
        return false;
    }

    public final void b(int n, int n2) {
        this.i = n;
        this.j = n2;
    }

    public static void a() {
        try {
            if (x == null) {
                m = new Image[16];
                n = new Image[16];
                o = new Image[4];
                y = Image.createImage((String)"/Card.png");
                l = Image.createImage((String)"/Hand.png");
                x = Image.createImage((String)"/CardBack.png");
                int n = 0;
                while (n < 16) {
                    if (n < 4) {
                        thien_by.o[n] = Image.createImage((String)("/Suit" + (n + 4) + ".png"));
                    }
                    if (n > 2) {
                        thien_by.n[n] = Image.createImage((String)("/b" + (n - 3) + ".png"));
                        thien_by.m[n] = Image.createImage((String)("/r" + (n - 3) + ".png"));
                    }
                    ++n;
                }
                k = Image.createImage((String)"/LostTurn.png");
                return;
            }
        }
        catch (Exception exception) {
            System.out.println("a= " + exception.toString());
        }
    }

    public final void a(Graphics graphics) {
        int n = this.j;
        int n2 = this.i;
        Graphics graphics2 = graphics;
        graphics2.drawImage(y, n2, n, 0);
        boolean bl = this.f;
        int n3 = this.j + u;
        int n4 = this.i + t;
        n = this.e;
        n2 = this.d;
        graphics2 = graphics;
        if (n == 0 || n == 1) {
            int n5 = n4;
            int n6 = n3;
            n3 = n2;
            n4 = bl ? 1 : 0;
            n = n6;
            n2 = n5;
            graphics2.drawImage(thien_by.n[n3], n2, n, 3);
            if (n4 != 0) {
                graphics2.drawRegion(thien_by.n[n3], 0, 0, 8, 9, 3, a + n2 - p, b + n - q, 3);
            }
        } else {
            int n7 = n4;
            int n8 = n3;
            n3 = n2;
            n4 = bl ? 1 : 0;
            n = n8;
            n2 = n7;
            graphics2.drawImage(m[n3], n2, n, 3);
            if (n4 != 0) {
                graphics2.drawRegion(m[n3], 0, 0, 8, 9, 3, a + n2 - p, b + n - q, 3);
            }
        }
        n3 = this.f ? 1 : 0;
        n4 = this.j + w;
        n = this.i + v;
        n2 = this.e;
        graphics2 = graphics;
        int n9 = n;
        int n10 = n4;
        n4 = n2;
        n = n3;
        n2 = n10;
        int n11 = n9;
        Graphics graphics3 = graphics2;
        graphics2.drawImage(o[n4], n11, n2, 3);
        if (n != 0) {
            graphics3.drawRegion(o[n4], 0, 0, 8, 8, 3, a + n11 - r, b + n2 - s, 3);
        }
    }

    public final void b(Graphics graphics) {
        thien_by.a(graphics, this.i, this.j);
    }

    public static void a(Graphics graphics, int n, int n2) {
        graphics.drawImage(x, n, n2, 20);
    }
}
