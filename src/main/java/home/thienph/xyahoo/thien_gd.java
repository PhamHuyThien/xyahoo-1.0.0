package home.thienph.xyahoo;

final class thien_gd
implements IAction {
    private BuddyListScreen a;

    thien_gd(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.startChatWithUser();
    }
}
