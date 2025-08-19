package home.thienph.xyahoo;

import java.util.Vector;

final class thien_bh implements IAction
{
    final BigTwoGameScreen a;
    
    thien_bh(final BigTwoGameScreen a) {
        this.a = a;
    }
    
    public final void action() {
        if (BigTwoGameScreen.d(this.a) == null) {
            final Vector vector = new Vector();
            BigTwoGameScreen.a(this.a, new PopupSideElementData(vector));
            vector.addElement(BigTwoGameScreen.e(this.a));
            vector.addElement(BigTwoGameScreen.f(this.a));
            vector.addElement(new UIAction("R\u1eddi b\u00e0n", new thien_bi(this)));
        }
        GameManager.getInstance().showPopupSideLayout(BigTwoGameScreen.d(this.a), 0);
    }
}
