package home.thienph.xyahoo;

final class thien_eq
implements IAction {
    private thien_em a;

    thien_eq(thien_em thien_em2) {
        this.a = thien_em2;
    }

    public final void action() {
        thien_di.getInstance().c(this.a);
    }
}
