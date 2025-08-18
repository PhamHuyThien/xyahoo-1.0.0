package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

final class thien_gv
        implements IAction {
    private thien_gp a;

    thien_gv(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        if (!this.a.C) {
            thien_di.instance.a(TextConstant.pleaseWait(), (Image)null, 1);
            return;
        }
        thien_gp.a(this.a);
    }
}
