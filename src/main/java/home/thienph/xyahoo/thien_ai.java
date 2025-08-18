package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ai
extends UIControlBase {
    private String c;
    private boolean d;
    public int a = 0xFFFFFF;
    public Integer b = thien_w.d;
    private int e;
    private boolean f;

    public thien_ai() {
        this.f = true;
    }

    private thien_ai(String string) {
        this.isVisible = false;
        this.c = thien_w.a(string, false);
        if (this.c == null) {
            this.d = false;
            this.c = string;
        } else {
            this.d = true;
        }
        this.e = this.c.length();
    }

    public thien_ai(String string, int n, int n2, int n3, int n4) {
        this(string);
        this.baseX = n;
        this.baseY = n2;
        this.width = thien_w.a(string, thien_w.j);
        this.height = n3;
        this.selectedIndex = n4;
        this.e = this.c.length();
    }

    public thien_ai(String string, int n, int n2, int n3) {
        this(string, n, n2, n3, -1);
    }

    public final boolean handleKeyInput(int n) {
        return true;
    }

    public final void draw(Graphics graphics) {
        if (this.f) {
            return;
        }
        boolean bl = this.isSelected();
        if (!this.d) {
            if (bl) {
                graphics.setColor(2580);
                graphics.fillRoundRect(this.baseX - 1, this.baseY + 2, this.width + 7, this.height, 8, 8);
            }
            this.a(graphics, this.c, this.baseX + 2, this.baseY + 2);
        }
        if (this.e == 0) {
            graphics.setColor(UIColorPalette.getPrimaryColor());
            graphics.fillRect(this.baseX, this.baseY + (this.height >> 1), Screen.e - this.baseX - 5, 1);
            return;
        }
        if (!this.d) {
            return;
        }
        if (bl) {
            graphics.setColor(2580);
            graphics.fillRoundRect(this.baseX - 1, this.baseY + 2, Screen.e - this.baseX - 2, this.height, 8, 8);
        }
        String string = "";
        int n = 0;
        int n2 = this.baseY + 2;
        int n3 = 0;
        while (n3 < this.e) {
            int n4 = this.c.charAt(n3);
            if (n4 >= 30000) {
                this.a(graphics, string, this.baseX + 2 + n, n2);
                string = "";
                graphics.drawRegion(thien_di.u, (n4 -= 30000) * 18, 0, 18, 18, 0, this.baseX + 2 + (n += thien_w.a(string, thien_w.j)) + 10, this.baseY + (thien_w.f >> 1), 3);
                n += 20;
            } else {
                string = String.valueOf(string) + (char)n4;
            }
            ++n3;
        }
        this.a(graphics, string, this.baseX + 2 + n, n2);
    }

    private void a(Graphics graphics, String string, int n, int n2) {
        graphics.setColor(this.a);
        thien_w.a(this.b).a(string, n, n2, graphics);
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final void update() {
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
