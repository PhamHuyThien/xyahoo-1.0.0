package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class UIDropdown
extends UIControlBase {
    public String[] a;
    private int c;
    private int d = 0;
    public IAction b;
    private String e = "";

    public UIDropdown(String[] stringArray, int n, int n2, int n3, int n4) {
        this.a = stringArray;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.g();
    }

    public final int a() {
        return this.c;
    }

    public final void c(int n) {
        this.c = n;
        this.g();
    }

    public final boolean handleSoftKey(int n) {
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
            this.b.action();
        }
        this.g();
    }

    private void d() {
        ++this.c;
        if (this.c >= this.a.length) {
            this.c = 0;
        }
        if (this.b != null) {
            this.b.action();
        }
        this.g();
    }

    public final boolean handleKeyInput(int n) {
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

    public final void handleKeyPress(int n, int n2) {
        this.parentScreen.selectControl(this);
        ++this.c;
        if (this.c >= this.a.length) {
            this.c = 0;
        }
        if (this.b != null) {
            this.b.action();
        }
        this.g();
    }

    private void g() {
        if (this.a.length != 0) {
            this.e = TextRenderer.wrapText(this.a[this.c], this.width - 35, TextRenderer.charWidth);
        }
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        if (bl) {
            graphics.setColor(2580);
            graphics.fillRect(this.baseX + 2, this.baseY + 2, this.width - 3, this.height - 3);
        }
        int n = this.baseY + 3 + (TextRenderer.useCustomFont ? 0 : 1);
        graphics.setColor(0xFFFFFF);
        if (this.a.length == 0) {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(TextConstant.noItem(), this.baseX + (this.width >> 1), n, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        } else {
            TextRenderer.getFontRenderer(TextRenderer.colorWhite).drawText(this.e, this.baseX + (this.width >> 1), n, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        }
        n = this.height - 2;
        int n2 = this.baseY + 1;
        graphics.setColor(bl ? 14675958 : 9478569);
        UIButton.a(graphics, this.baseX + 1, n2, this.width - 2, n);
        n = this.baseY + (this.height >> 1);
        graphics.drawImage(thien_b.b[2], this.baseX + 9, n, 3);
        graphics.drawImage(thien_b.b[3], this.baseX + this.width - 9, n, 3);
    }

    public final void a(IAction IAction2) {
        this.b = IAction2;
        if (this.actionTertiary != null) {
            this.actionTertiary.actionHandler = IAction2;
        }
    }

    public final void update() {
        if (this.d > 0) {
            --this.d;
            if (this.d == 0 && this.b != null) {
                this.b.action();
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
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
