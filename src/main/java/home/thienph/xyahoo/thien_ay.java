package home.thienph.xyahoo;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ay
extends UIControlBase {
    public static Image a;
    public static Image b;
    private static Image d;
    private static Image e;
    private static Image f;
    private static Image g;
    private static int h;
    private static int i;
    private static int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    public static thien_aw[] c;
    private int J;
    private int K;

    public thien_ay(int n, int n2, int n3) {
        this.width = n;
        this.height = n2;
        this.isEnabled = true;
        this.k = n3;
        if (b == null) {
            try {
                b = Image.createImage((String)"/play.png");
                a = Image.createImage((String)"/Table.png");
                f = Image.createImage((String)"/PTop.png");
                g = Image.createImage((String)"/PBottom.png");
                d = Image.createImage((String)"/PLeft.png");
                e = Image.createImage((String)"/PRight.png");
                h = a.getWidth();
                i = a.getHeight();
                j = i >> 1;
            }
            catch (IOException iOException) {}
        }
        this.actionTertiary = new UIAction("V\u00e0o b\u00e0n", new thien_az(this));
        this.J = c.length;
        this.m = Screen.e / (h + 20);
        this.l = this.J % this.m == 0 ? this.J / this.m : this.J / this.m + 1;
        this.C = (Screen.e - this.m * 50) / (this.m + 1);
        this.D = this.C + 25;
        this.G = 50 + this.C;
        this.E = 25;
        this.F = 0;
        this.H = i << 1;
        this.I = (this.E + this.l * this.H + (i + 15) - n2) / this.H;
        this.B = 0;
        this.n = 0;
        this.handleFocus();
    }

    private boolean d(int n, int n2) {
        return n == this.n && n2 == this.B;
    }

    private boolean e(int n, int n2) {
        return n * this.m + n2 <= this.J - 1;
    }

    public final void draw(Graphics graphics) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n5 < c.length) {
            n3 = n5 / this.m;
            n4 = n5 % this.m;
            n = this.D + n4 * this.G;
            n2 = this.E + n3 * this.H + this.F;
            if (this.d(n3, n4)) {
                UIButton.a(graphics, n - 35, n2 - 27, h + 22, i + 31, 8);
            }
            graphics.drawImage(a, n, n2, 3);
            if (c[n5].a() > 0) {
                graphics.drawImage(f, n, n2 - 24, 17);
            }
            if (c[n5].a() > 1) {
                graphics.drawImage(g, n, n2 + 2, 17);
            }
            if (c[n5].a() > 2) {
                graphics.drawImage(d, n - 32, n2, 6);
            }
            if (c[n5].a() > 3) {
                graphics.drawImage(e, n + 10, n2, 6);
            }
            if (thien_ay.c[n5].b != 1) {
            } else {
                graphics.drawImage(b, n, n2, 3);
            }
            graphics.setColor(0xFFFFFF);
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(thien_ay.c[n5].c, n - 1, n2 + j + 5, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
            ++n5;
        }
    }

    public final boolean handleKeyInput(int n) {
        boolean bl = true;
        switch (n) {
            case 14: {
                if (this.B <= 0) break;
                --this.B;
                bl = false;
                break;
            }
            case 15: {
                if (this.B >= this.m - 1 || !this.e(this.n, this.B + 1)) break;
                ++this.B;
                bl = false;
                break;
            }
            case 12: {
                if (this.n > 0) {
                    --this.n;
                    if (this.F < 0) {
                        this.F += this.H;
                    }
                } else {
                    this.n = this.l - 1;
                    n = this.I;
                    if (!this.e(this.n, this.B)) {
                        --this.n;
                        --n;
                    }
                    this.F -= n * this.H;
                }
                bl = false;
                if (!thien_ar.a) break;
                thien_ar.a(true);
                break;
            }
            case 13: {
                n = this.B;
                while (n >= 0) {
                    if (this.n == this.l - 1) {
                        this.n = 0;
                        this.F = 0;
                        break;
                    }
                    if (this.e(this.n + 1, n)) {
                        ++this.n;
                        this.B = n;
                        n = Screen.formHeight - Screen.topMargin - (i << 1);
                        if (this.E + this.n * this.H <= n) break;
                        this.F -= this.H;
                        break;
                    }
                    --n;
                }
                bl = false;
                if (!thien_ar.a) break;
                thien_ar.a(true);
            }
        }
        return bl;
    }

    public final void update() {
    }

    public final boolean handleSoftKey(int n) {
        if (n == 13 || n == 12) {
            this.handleKeyInput(n);
            return false;
        }
        return true;
    }

    public final void handleFocus() {
        thien_ar.a = true;
        thien_ar.a(this.l);
    }

    public final void drawScrollbar(Graphics graphics) {
        if (thien_ar.a) {
            thien_ar.a(graphics, this.n);
        }
    }

    public final void onDrag(int n, int n2) {
        this.K = n2;
    }

    public final void handleKeyPress(int n, int n2) {
        n2 += Screen.headerHeight;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < this.J) {
            n5 = n7 / this.m;
            n6 = n7 % this.m;
            n3 = this.D + n6 * this.G;
            n4 = this.E + n5 * this.H + this.F;
            if (n > n3 - 25 && n < n3 + h - 15 && n2 > n4 - 10 && n2 < n4 + i + 15) {
                if (this.d(n5, n6)) {
                    this.actionTertiary.actionHandler.action();
                    break;
                }
                this.n = n5;
                this.B = n6;
                break;
            }
            ++n7;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void handlePointerRelease(int n, int n2) {
        n = n2 - this.K;
        if (UIBuddyListControl.c(n) > 10) {
            if (n > 0) {
                this.F += n;
                if (this.F > 0) {
                    this.F = 0;
                }
            } else {
                this.F += n;
                if (this.F < -this.I * this.H) {
                    this.F = -this.I * this.H;
                }
            }
            this.K = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    static int a(thien_ay thien_ay2) {
        return thien_ay2.n * thien_ay2.m + thien_ay2.B;
    }

    static int b(thien_ay thien_ay2) {
        return thien_ay2.k;
    }
}
