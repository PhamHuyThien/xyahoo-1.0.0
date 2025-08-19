package home.thienph.xyahoo;

final class thien_gf
implements IAction {
    private BuddyListScreen a;

    thien_gf(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.broadcastMessage();
    }
}
