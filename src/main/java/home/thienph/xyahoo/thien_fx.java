package home.thienph.xyahoo;

final class thien_fx
implements IAction {
    private BuddyListScreen a;

    thien_fx(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.showChangeFullName();
    }
}
