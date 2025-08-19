package home.thienph.xyahoo;

final class thien_fy
implements IAction {
    private BuddyListScreen a;

    thien_fy(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.showChangePassword();
    }
}
