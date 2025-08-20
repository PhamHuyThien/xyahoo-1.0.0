package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.UIAction;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

import java.util.Vector;

public final class thien_bh implements IAction {
    final BigTwoGameScreen bigTwoGameScreen;

    public thien_bh(final BigTwoGameScreen bigTwoGameScreen) {
        this.bigTwoGameScreen = bigTwoGameScreen;
    }

    public final void action() {
        if (BigTwoGameScreen.getContextMenuData(this.bigTwoGameScreen) == null) {
            final Vector vector = new Vector();
            BigTwoGameScreen.setContextMenuData(this.bigTwoGameScreen, new PopupSideElementData(vector));
            vector.addElement(BigTwoGameScreen.getChatAction(this.bigTwoGameScreen));
            vector.addElement(BigTwoGameScreen.getSmileyAction(this.bigTwoGameScreen));
            vector.addElement(new UIAction("Rời bàn", new thien_bi(this)));
        }
        GameManager.getInstance().showSideMenu(BigTwoGameScreen.getContextMenuData(this.bigTwoGameScreen), 0);
    }
}
