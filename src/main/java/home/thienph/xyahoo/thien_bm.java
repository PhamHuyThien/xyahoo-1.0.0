package home.thienph.xyahoo;

final class thien_bm
implements IAction {
    private thien_ba a;

    thien_bm(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        this.a.addControl(thien_ba.I);
        thien_ba.J = true;
        this.a.selectControl(thien_ba.I);
        thien_ba.a(this.a);
    }
}
