package home.thienph.xyahoo;

final class thien_bv
implements IAction {
    private thien_ba a;

    thien_bv(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        thien_di.getInstance().a(thien_ba.b(this.a), 0);
        thien_ba.a(this.a);
    }
}
