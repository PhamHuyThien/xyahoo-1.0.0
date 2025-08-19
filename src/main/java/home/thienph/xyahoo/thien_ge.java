package home.thienph.xyahoo;

final class thien_ge
implements IAction {
    private BuddyListScreen a;

    thien_ge(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.createConference();
    }
}
