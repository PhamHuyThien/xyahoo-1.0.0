package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_em
extends Screen {
    thien_al w;
    int x;
    private Vector A;
    thien_am y;
    public static UIAction z = new UIAction("N\u1ea1p xuxu", new thien_en());

    public thien_em() {
        this.isLocked = true;
        this.w = new thien_al(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.g, 0);
        this.addControl(this.w);
        this.selectControl(this.w);
        this.rightCommand = new UIAction("T\u00ecm ph\u00f2ng", new thien_eo(this));
        this.A = new Vector();
        this.A.addElement(new UIAction(TextConstant.update(), new thien_ep(this)));
        this.A.addElement(z);
        this.A.addElement(new UIAction(TextConstant.close(), new thien_eq(this)));
        this.y = new thien_am(this.A);
        this.leftCommand = new UIAction("Menu", new thien_er(this));
    }

    public final void updateLayout() {
        this.w.handleFocus();
    }

    public final void drawOverlay(Graphics graphics) {
        this.w.drawScrollbar(graphics);
    }
}
