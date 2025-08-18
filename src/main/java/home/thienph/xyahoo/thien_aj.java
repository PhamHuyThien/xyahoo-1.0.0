package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_aj
extends UIControlBase {
    private String[] c;
    public Integer a;
    private int d;
    public IAction b;
    private int e;
    private int f;
    private int g;

    public thien_aj() {
    }

    public thien_aj(final String s, final int q, final int r, final int s2, final int e) {
        this.d = 0;
        this.c = thien_w.c(s, Screen.e - q, thien_w.j);
        this.a = thien_w.e;
        String[] c;
        for (int a = thien_w.a((c = this.c)[0], thien_w.j), i = 1; i < c.length; ++i) {
            final int a2 = thien_w.a(c[i], thien_w.j);
            if (a < a2) {
                a = a2;
            }
        }
        super.baseX = q;
        super.baseY = r;
        super.width = s2;
        this.e = e;
        super.height = e * this.c.length;
        super.actionTertiary = new UIAction(TextConstant.select(), null);
        this.f = (e >> 1) + 2;
        this.g = (e - thien_w.f >> 1) + 1;
    }

    public final boolean handleKeyInput(int n) {
        if (n == 16) {
            this.d = 2;
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.isSelected()) {
            this.b.action();
            return;
        }
        this.parentScreen.selectControl(this);
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        int n = this.baseX;
        graphics.setColor(this.a.intValue());
        int n2 = 0;
        while (n2 < this.c.length) {
            thien_w.a(this.a).a(this.c[n2], n + 2, this.baseY + this.e * n2 + this.g, graphics);
            if (bl) {
                graphics.setColor(8111862);
                graphics.fillRect(n + 2, this.baseY + this.e * n2 + this.e - (thien_w.a ? 1 : 3), thien_w.a(this.c[n2], thien_w.j) + 2, 1);
            }
            ++n2;
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

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
