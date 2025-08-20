package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fz
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_fz(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        DisplayItem displayItem2 = this.buddyListScreen.buddyList.getSelectedItem();
        if (displayItem2 == null) {
            return;
        }
        if (displayItem2.itemType == 0) {
            this.buddyListScreen.moveUserToGroup();
            return;
        }
        this.buddyListScreen.renameGroup();
    }
}
