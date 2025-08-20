package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_gh
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_gh(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.buddyListScreen.popupMenuData, 0);
    }
}
