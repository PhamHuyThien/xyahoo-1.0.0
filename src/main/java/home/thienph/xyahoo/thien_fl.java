package home.thienph.xyahoo;

final class thien_fl
implements IAction {
    private final Screen a;

    thien_fl(BuddyListScreen buddyListScreen2, Screen screen2) {
        this.a = screen2;
    }

    public final void action() {
        GameManager.getInstance().c(this.a);
        GameManager.instance.l();
    }
}
