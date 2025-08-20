package home.thienph.xyahoo;

final class thien_fh
implements IAction {
    private final Screen a;

    thien_fh(BuddyListScreen buddyListScreen2, Screen screen2) {
        this.a = screen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.a);
        GameManager.instance.focusBuddyList();
    }
}
