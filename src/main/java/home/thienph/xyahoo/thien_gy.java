package home.thienph.xyahoo;

final class thien_gy
implements IAction {
    private thien_gp a;

    thien_gy(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        GameManager.getInstance().a(this.a.B, 0);
    }
}
