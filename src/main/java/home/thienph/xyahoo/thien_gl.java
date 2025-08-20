package home.thienph.xyahoo;

final class thien_gl
implements IAction {
    private final Screen a;

    thien_gl(BuddyListScreen buddyListScreen2, Screen screen2) {
        this.a = screen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.a);
        GameManager.instance.focusBuddyList();
    }
}
