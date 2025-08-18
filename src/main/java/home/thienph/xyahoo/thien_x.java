package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_x
extends UIControlBase {
    private String c;
    private int d;
    public boolean a;
    public IAction b;

    public thien_x(String string, int n, int n2, int n3, int n4) {
        this.c = string;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.actionSecondary = new UIAction(TextConstant.select(), null);
    }

    public final boolean handleSoftKey(int n) {
        return this.handleKeyInput(n);
    }

    public final boolean handleKeyInput(int n) {
        if (n == 18) {
            this.d = 2;
            return false;
        }
        return true;
    }

    private void a() {
        boolean bl = this.a = !this.a;
        if (this.b != null) {
            this.b.action();
        }
    }

    public final void handleKeyPress(int n, int n2) {
        this.parentScreen.selectControl(this);
        this.a();
    }

    public final void update() {
        if (this.d > 0) {
            --this.d;
            if (this.d == 0) {
                this.a();
            }
        }
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        graphics.drawImage(this.a ? thien_di.y[1] : thien_di.y[0], this.baseX + 8, this.baseY + (this.height >> 1) + 1, 3);
        if (bl) {
            graphics.setColor(14675958);
            graphics.drawRoundRect(this.baseX + 13 + 4, this.baseY + 1, this.width - 13, this.height, 5, 5);
        }
        graphics.setColor(0xFFFFFF);
        thien_w.a(thien_w.d).a(this.c, this.baseX + 13 + 5, this.baseY + 3, graphics);
    }

    public final void drawBackground(Graphics graphics) {
    }
}
