package home.thienph.xyahoo;

final class thien_gz
implements IAction {
    private thien_gp a;

    thien_gz(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        this.a.f();
    }
}
