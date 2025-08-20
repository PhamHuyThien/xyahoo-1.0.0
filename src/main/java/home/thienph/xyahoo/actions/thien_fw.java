package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fw
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_fw(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        if (BuddyListScreen.isRankingEnabled = !BuddyListScreen.isRankingEnabled) {
            BuddyListScreen buddyListScreen2 = this.buddyListScreen;
            buddyListScreen2.buddyList.d();
        }
        Xuka.saveFlag("onrank", BuddyListScreen.isRankingEnabled);
    }
}
