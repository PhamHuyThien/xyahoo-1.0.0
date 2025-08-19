package home.thienph.xyahoo;

final class thien_fu
implements IAction {
    private BuddyListScreen a;

    thien_fu(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.showStatusSettings();
    }
}
