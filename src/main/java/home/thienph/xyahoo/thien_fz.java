package home.thienph.xyahoo;

final class thien_fz
implements IAction {
    private BuddyListScreen a;

    thien_fz(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        thien_u thien_u2 = this.a.buddyList.h();
        if (thien_u2 == null) {
            return;
        }
        if (thien_u2.a == 0) {
            this.a.moveUserToGroup();
            return;
        }
        this.a.renameGroup();
    }
}
