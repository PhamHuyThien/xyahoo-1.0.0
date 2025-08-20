package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fi
implements IAction {
    private final PopupSideElementData popupSideElementData;

    public thien_fi(BuddyListScreen buddyListScreen2, PopupSideElementData popupSideElementData2) {
        this.popupSideElementData = popupSideElementData2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.popupSideElementData, 0);
    }
}
