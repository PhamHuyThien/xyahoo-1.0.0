package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.IAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.utils.TextRenderer;

import javax.microedition.lcdui.Graphics;

public final class UIButton
extends UIControlBase {
    private String b;
    private int c;
    public IAction a;
    private static int d;
    private static int e;
    private static int f;
    private static int g;

    public UIButton() {
    }

    public UIButton(String string, int n, int n2, int n3, int n4) {
        this.c = 0;
        this.b = string;
        this.baseX = n;
        this.baseY = n2;
        this.width = n3;
        this.height = n4;
        this.actionTertiary = new UIAction(TextConstant.select(), null);
    }

    public final boolean handleKeyInput(int n) {
        if (n == 16) {
            this.c = 2;
            return false;
        }
        return true;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.isSelected()) {
            this.a.action();
            return;
        }
        this.parentScreen.selectControl(this);
    }

    public final void draw(Graphics graphics) {
        boolean bl = this.isSelected();
        graphics.setColor(bl ? 11918844 : 1124399);
        graphics.fillRect(this.baseX + 2, this.baseY + 2, this.width - 3, this.height - 3 >> 1);
        graphics.setColor(bl ? 9291764 : 728097);
        graphics.fillRect(this.baseX + 2, this.baseY + 1 + (this.height - 3 >> 1), this.width - 3, 2 + (this.height - 3 >> 1));
        graphics.setColor(bl ? 0 : 0xFFFFFF);
        TextRenderer.getFontRenderer(bl ? TextRenderer.colorSecondary : TextRenderer.colorWhite).drawText(this.b, this.baseX + (this.width >> 1), this.baseY + 3, 2, graphics, TextRenderer.charWidth, TextRenderer.fontHeight);
        graphics.setColor(bl ? 14675958 : 9478569);
        UIButton.a(graphics, this.baseX + 1, this.baseY + 1, this.width - 2, this.height - 2);
    }

    public final void update() {
        if (this.c > 0) {
            --this.c;
            if (this.c == 0 && this.a != null) {
                this.a.action();
            }
        }
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4) {
        e = n + ++n3 - 2;
        g = n2 + ++n4 - 2;
        f = n + 1;
        graphics.fillRect(f, g, 1, 1);
        graphics.fillRect(e, g, 1, 1);
        g = n2 + 1;
        graphics.fillRect(f, g, 1, 1);
        graphics.fillRect(e, g, 1, 1);
        d = n4 - 4;
        e = n2 + 2;
        graphics.fillRect(n, e, 1, d);
        graphics.fillRect(n + n3 - 1, e, 1, d);
        d = n + 2;
        e = n3 - 4;
        graphics.fillRect(d, n2, e, 1);
        graphics.fillRect(d, n2 + n4 - 1, e, 1);
    }

    public static void a(Graphics graphics, int n, int n2, int n3, int n4, int n5) {
        graphics.setColor(11320516);
        graphics.fillRoundRect(n, n2, n3, n4, 8, 8);
        graphics.setColor(2580);
        graphics.fillRoundRect(n + 1, n2 + 1, n3 - 2, n4 - 2, 8, 8);
    }

    public final boolean handleSoftKey(int n) {
        return true;
    }
}
