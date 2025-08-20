package home.thienph.xyahoo;

final class thien_gh
implements IAction {
    private BuddyListScreen a;

    thien_gh(BuddyListScreen buddyListScreen2) {
        this.a = buddyListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.a.popupMenuData, 0);
    }
}
