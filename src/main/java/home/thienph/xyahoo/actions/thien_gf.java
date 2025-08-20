package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_gf
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_gf(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        this.buddyListScreen.broadcastMessage();
    }
}
