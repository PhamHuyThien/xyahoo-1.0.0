package home.thienph.xyahoo;

final class thien_gu
implements IAction {
    private thien_gp a;

    thien_gu(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        thien_di.getInstance().c(thien_gp.d(this.a));
    }
}
