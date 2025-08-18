package home.thienph.xyahoo;

final class thien_bp
implements IAction {
    private thien_ba a;

    thien_bp(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        this.a.removeControl(thien_ba.h());
        thien_ba.H = false;
        this.a.selectControl(thien_ba.g(this.a));
        thien_ba.a(this.a);
        thien_ba.h().setText("");
    }
}
