package home.thienph.xyahoo;

import java.util.Vector;

final class thien_bh implements IAction
{
    final BigTwoGameScreen a;
    
    thien_bh(final BigTwoGameScreen a) {
        this.a = a;
    }
    
    public final void action() {
        if (BigTwoGameScreen.getContextMenuData(this.a) == null) {
            final Vector vector = new Vector();
            BigTwoGameScreen.setContextMenuData(this.a, new PopupSideElementData(vector));
            vector.addElement(BigTwoGameScreen.getChatAction(this.a));
            vector.addElement(BigTwoGameScreen.getSmileyAction(this.a));
            vector.addElement(new UIAction("Rời bàn", new thien_bi(this)));
        }
        GameManager.getInstance().showSideMenu(BigTwoGameScreen.getContextMenuData(this.a), 0);
    }
}
