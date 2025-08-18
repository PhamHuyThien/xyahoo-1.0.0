package home.thienph.xyahoo;

final class thien_br
implements IAction {
    private thien_ba a;

    thien_br(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        this.a.addControl(thien_ba.h());
        this.a.selectControl(thien_ba.h());
        thien_ba.H = true;
        thien_ba.a(this.a);
    }
}
