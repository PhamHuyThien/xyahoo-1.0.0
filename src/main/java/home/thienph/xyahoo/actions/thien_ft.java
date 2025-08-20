package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_ft
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_ft(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        this.buddyListScreen.showAddFriendScreen("");
    }
}
