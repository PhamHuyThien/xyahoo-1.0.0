package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fv
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_fv(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        this.buddyListScreen.buddyList.isFilterActive = !this.buddyListScreen.buddyList.isFilterActive;
        this.buddyListScreen.buddyList.rebuildVisibleItems();
        this.buddyListScreen.buddyList.selectedItemIndex = 0;
    }
}
