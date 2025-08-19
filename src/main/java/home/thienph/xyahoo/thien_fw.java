package home.thienph.xyahoo;

final class thien_fw
implements IAction {
    private BuddyListScreen a;

    thien_fw(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        if (BuddyListScreen.isRankingEnabled = !BuddyListScreen.isRankingEnabled) {
            BuddyListScreen buddyListScreen2 = this.a;
            buddyListScreen2.buddyList.d();
        }
        Xuka.saveFlag("onrank", BuddyListScreen.isRankingEnabled);
    }
}
