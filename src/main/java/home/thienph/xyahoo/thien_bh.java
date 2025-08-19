package home.thienph.xyahoo;

import java.util.Vector;

final class thien_bh implements IAction
{
    final thien_ba a;
    
    thien_bh(final thien_ba a) {
        this.a = a;
    }
    
    public final void action() {
        if (thien_ba.d(this.a) == null) {
            final Vector vector = new Vector();
            thien_ba.a(this.a, new PopupSideElementData(vector));
            vector.addElement(thien_ba.e(this.a));
            vector.addElement(thien_ba.f(this.a));
            vector.addElement(new UIAction("R\u1eddi b\u00e0n", new thien_bi(this)));
        }
        GameManager.getInstance().showPopupSideLayout(thien_ba.d(this.a), 0);
    }
}
