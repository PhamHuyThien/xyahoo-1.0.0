package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_gc
        implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_gc(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        thien_gc thien_gc2 = this;
        thien_gc2.buddyListScreen.n();
    }
}
