package home.thienph.xyahoo;

final class thien_cj
implements IAction {
    private thien_ca a;

    thien_cj(thien_ca thien_ca2) {
        this.a = thien_ca2;
    }

    public final void action() {
        GameManager.getInstance().a(this.a.E, 0);
    }
}
