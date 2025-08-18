package home.thienph.xyahoo;

final class thien_gr
implements IAction {
    private thien_gp a;

    thien_gr(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        thien_di.getInstance().c(this.a);
    }
}
