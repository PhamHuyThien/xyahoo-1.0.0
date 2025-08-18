package home.thienph.xyahoo;

final class thien_fd
implements IAction {
    private thien_ew a;

    thien_fd(thien_ew thien_ew2) {
        this.a = thien_ew2;
    }

    public final void action() {
        GameManager.getInstance().a(thien_ew.a(this.a), 0);
    }
}
