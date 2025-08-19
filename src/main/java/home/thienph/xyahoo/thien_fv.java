package home.thienph.xyahoo;

final class thien_fv
implements IAction {
    private BuddyListScreen a;

    thien_fv(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        this.a.buddyList.isFilterActive = !this.a.buddyList.isFilterActive;
        this.a.buddyList.c();
        this.a.buddyList.selectedGroupIndex = 0;
    }
}
