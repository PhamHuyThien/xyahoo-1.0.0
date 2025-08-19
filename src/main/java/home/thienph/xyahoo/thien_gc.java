package home.thienph.xyahoo;

final class thien_gc
        implements IAction {
    private BuddyListScreen a;

    thien_gc(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        thien_gc thien_gc2 = this;
        thien_gc2.a.n();
    }
}
