package home.thienph.xyahoo;

final class thien_bd
implements IAction {
    private thien_ba a;

    thien_bd(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        thien_di.getInstance().a(thien_ba.c(this.a), 0);
    }
}
