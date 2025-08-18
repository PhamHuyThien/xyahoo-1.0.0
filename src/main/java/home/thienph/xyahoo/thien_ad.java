package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ad {
    public UIAction a;
    public UIAction b;
    public UIAction c;
    private String[] e;
    public boolean d = false;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public thien_ad(String string, UIAction UIAction2, UIAction UIAction3, UIAction UIAction4) {
        this.e = thien_w.b(string, GameCanvas.screenWidth - 30, thien_w.j);
        this.a = UIAction2;
        this.c = UIAction4;
        this.b = UIAction3;
        this.a();
    }

    public thien_ad(String[] stringArray, UIAction UIAction2, UIAction UIAction3, UIAction UIAction4) {
        this.e = stringArray;
        this.a = UIAction2;
        this.c = UIAction4;
        this.b = UIAction3;
        this.a();
    }

    public final void a(boolean bl) {
        this.d = bl;
        this.a();
    }

    private void a() {
        this.f = this.e.length;
        this.k = this.f * (thien_w.f + 2) + (this.d ? 20 : 0);
        this.l = this.k + (thien_w.f << 1) - 1;
        if (this.l < 30) {
            this.l = 30;
        }
        if (this.l > GameCanvas.screenHeight - 35) {
            this.l = this.k = GameCanvas.screenHeight - 35;
        }
        int n = 0;
        while (n < this.f) {
            int n2 = thien_w.a(this.e[n], thien_w.j) + 10;
            if (this.m < n2) {
                this.m = n2;
            }
            ++n;
        }
        this.m += 60;
        if (this.m < 100) {
            this.m = 100;
        }
        if (this.m > GameCanvas.screenWidth - 15) {
            this.m = GameCanvas.screenWidth - 15;
        }
        this.n = GameCanvas.screenHeight - this.l >> 1;
        this.o = this.n + (this.l - this.k >> 1) + 1;
        this.h = this.n + 1;
        this.i = this.m - 2;
        this.j = this.l - 2;
    }

    public final void a(Graphics graphics) {
        int n;
        this.g = (GameCanvas.screenWidth - this.m >> 1) + 1;
        graphics.setClip(this.g, this.h, this.i, this.j);
        int n2 = this.m / 50 + 1;
        while (--n2 >= 0) {
            n = this.l / 50 + 1;
            while (--n >= 0) {
                graphics.drawImage(thien_di.w, this.g + n2 * 50, this.h + n * 50, 0);
            }
        }
        if (this.m > 110) {
            graphics.drawRegion(thien_di.x, 0, 0, 55, 20, 0, this.g, this.h, 0);
            graphics.drawRegion(thien_di.x, 87, 0, 55, 20, 0, this.g + this.i - 55, this.h, 0);
            graphics.setClip(this.g + 55, this.h, this.i - 110, 20);
            n = n2 = (this.i - 110 >> 5) + 1;
            while (--n >= 0) {
                graphics.drawRegion(thien_di.x, 55, 0, 32, 20, 0, this.g + 55 + n * 32, this.h, 0);
            }
        }
        graphics.setClip(-1000, -1000, 5000, 5000);
        graphics.setColor(0xDDF3FF);
        thien_v.a(graphics, this.g - 1, this.n, this.m - 1, this.l - 1);
        graphics.drawRect(this.g - 1, this.n, this.m - 1, this.l - 1);
        thien_v.a(graphics, this.g - 2, this.n - 1, this.m + 1, this.l + 1);
        graphics.setClip(-1000, -1000, 5000, 5000);
        this.g = GameCanvas.screenWidth >> 1;
        graphics.setColor(0xFFFFFF);
        n2 = 0;
        while (n2 < this.f) {
            thien_w.a(thien_w.d).a(this.e[n2], this.g, this.o + n2 * (thien_w.f + 2), 2, graphics, thien_w.j, thien_w.f);
            ++n2;
        }
        if (this.d) {
            thien_di.instance.a(graphics, this.g, this.o + this.f * thien_w.f + thien_w.f + 3);
        }
        Screen.drawFooter(graphics);
        graphics.setColor(0xFFFFFF);
        n2 = GameCanvas.screenHeight - (thien_di.g >> 1) - (thien_w.f >> 1) + (thien_w.a ? 0 : 2);
        if (this.a != null) {
            thien_w.a(thien_w.d).a(this.a.label, 4, n2, graphics);
        }
        if (this.b != null) {
            thien_w.a(thien_w.d).a(this.b.label, this.g, n2, 2, graphics, thien_w.j, thien_w.f);
        }
        if (this.c != null) {
            thien_w.a(thien_w.d).a(this.c.label, GameCanvas.screenWidth - 4, n2, 1, graphics, thien_w.j, thien_w.f);
        }
    }
}
