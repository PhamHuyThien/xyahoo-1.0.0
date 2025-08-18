package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ag
extends thien_ac {
    private Image c;
    public byte[] a;
    private int d;
    private int e;
    public thien_ae b;
    private int[] f = null;

    static {
        String[] stringArray = new String[]{"/", "\\", "<", ">", "?", ":", "\"", "*", "|"};
    }

    public final void d(int n, int n2) {
        this.d = n;
        this.e = n2;
    }

    public final void a(Image image) {
        Image image2;
        int n = this.e;
        int n2 = this.d;
        int n3 = image.getWidth();
        int n4 = image.getHeight();
        if (n3 == n2 && n4 == n) {
            image2 = image;
        } else {
            Image image3 = Image.createImage((int)n2, (int)n);
            Graphics graphics = image3.getGraphics();
            int n5 = 0;
            while (n5 < n) {
                int n6 = 0;
                while (n6 < n2) {
                    graphics.setClip(n6, n5, 1, 1);
                    int n7 = n6 * n3 / n2;
                    int n8 = n5 * n4 / n;
                    graphics.drawImage(image, n6 - n7, n5 - n8, 20);
                    ++n6;
                }
                ++n5;
            }
            image2 = Image.createImage((Image)image3);
        }
        this.c = image2;
    }

    public thien_ag() {
        this.o = false;
        this.y = new thien_ab(thien_as.P(), new thien_ah(this));
    }

    public final boolean b(int n) {
        return true;
    }

    public final void b(int n, int n2) {
        if (this.b != null) {
            this.b.a();
            return;
        }
    }

    public final void a(Graphics graphics) {
        if (this.c != null) {
            graphics.drawImage(this.c, this.q, this.r, 0);
        }
        if (this.f != null) {
            int n = 0;
            while (n < this.f.length) {
                int n2 = this.f[n] >> 24;
                int n3 = this.f[n] << 8 >> 24;
                short s = (short)this.f[n];
                Image image = thien_ck.a(s);
                if (image != null) {
                    graphics.drawImage(image, this.q + (this.s >> 1) + n2, this.r + (this.t >> 1) + n3, 0);
                }
                ++n;
            }
        }
    }

    public final void b(Graphics graphics) {
        super.b(graphics);
        graphics.setColor(UIColorPalette.getSecondaryColor());
        graphics.drawRect(this.q, this.r, this.s, this.t);
        graphics.setColor(UIColorPalette.getHighlightColor());
        graphics.drawRect(this.q - 1, this.r - 1, this.s + 2, this.t + 2);
    }

    public final void e() {
    }

    public final void a(int[] nArray) {
        this.f = nArray;
    }

    public final boolean a(int n) {
        return true;
    }
}
