package home.thienph.xyahoo;

final class thien_er
implements IAction {
    private thien_em a;

    thien_er(thien_em thien_em2) {
        this.a = thien_em2;
    }

    public final void action() {
        thien_di.getInstance().a(this.a.y, 0);
    }
}
