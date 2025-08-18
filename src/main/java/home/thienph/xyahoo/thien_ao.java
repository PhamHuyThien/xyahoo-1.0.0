package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ao
extends UIControlBase {
    private String d;
    private int e;
    public FormScreen a;
    public int b;
    private int f;
    public boolean c;

    public thien_ao() {
    }

    public thien_ao(String string, int n, int n2, int n3, int n4) {
        this();
        this.e = 0;
        this.d = string;
        this.baseX = 0;
        this.baseY = 0;
        this.width = n3;
        this.height = n4 < 19 ? n4 : 19;
    }

    public final boolean handleKeyInput(int n) {
        if (n == 16) {
            this.e = 2;
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        this.a.toggleSection(this.b);
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        if (bl) {
            this.f = thien_w.a(this.d, thien_w.j);
            graphics.setColor(2580);
            graphics.fillRoundRect(this.baseX + 19, this.baseY, this.f + 10, this.height, 8, 8);
        }
        graphics.setColor(3981823);
        thien_w.a(thien_w.e).a(this.d, this.baseX + 23, this.baseY + (this.height - thien_w.f >> 1), graphics);
        graphics.drawImage(thien_b.b[this.c ? 0 : 1], this.baseX + 10, this.baseY + (this.height >> 1), 3);
    }

    public final void update() {
        if (this.e > 0) {
            --this.e;
            if (this.e == 0) {
                this.a.toggleSection(this.b);
            }
        }
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
