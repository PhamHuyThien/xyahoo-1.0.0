package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ag
extends UIControlBase {
    private Image c;
    public byte[] a;
    private int d;
    private int e;
    public IAction b;
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
        this.isVisible = false;
        this.actionTertiary = new UIAction(TextConstant.select(), new thien_ah(this));
    }

    public final boolean handleKeyInput(int n) {
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.b != null) {
            this.b.action();
            return;
        }
    }

    public final void draw(Graphics graphics) {
        if (this.c != null) {
            graphics.drawImage(this.c, this.baseX, this.baseY, 0);
        }
        if (this.f != null) {
            int n = 0;
            while (n < this.f.length) {
                int n2 = this.f[n] >> 24;
                int n3 = this.f[n] << 8 >> 24;
                short s = (short)this.f[n];
                Image image = ImageCacheManager.getImage(s);
                if (image != null) {
                    graphics.drawImage(image, this.baseX + (this.width >> 1) + n2, this.baseY + (this.height >> 1) + n3, 0);
                }
                ++n;
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
        super.drawBackground(graphics);
        graphics.setColor(UIColorConstant.getSecondaryColor());
        graphics.drawRect(this.baseX, this.baseY, this.width, this.height);
        graphics.setColor(UIColorConstant.getHighlightColor());
        graphics.drawRect(this.baseX - 1, this.baseY - 1, this.width + 2, this.height + 2);
    }

    public final void update() {
    }

    public final void a(int[] nArray) {
        this.f = nArray;
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
