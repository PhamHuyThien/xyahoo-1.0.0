package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fz
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_fz(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        thien_u thien_u2 = this.buddyListScreen.buddyList.h();
        if (thien_u2 == null) {
            return;
        }
        if (thien_u2.a == 0) {
            this.buddyListScreen.moveUserToGroup();
            return;
        }
        this.buddyListScreen.renameGroup();
    }
}
