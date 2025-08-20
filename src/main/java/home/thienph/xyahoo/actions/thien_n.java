package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_n
implements IAction {
    private final PopupSideElementData popupSideElementData;

    public thien_n(PopupSideElementData popupSideElementData2) {
        this.popupSideElementData = popupSideElementData2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.popupSideElementData, 0);
    }
}
