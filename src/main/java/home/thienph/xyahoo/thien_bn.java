package home.thienph.xyahoo;

final class thien_bn
implements IAction {
    private thien_ba a;

    thien_bn(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        this.a.removeControl(thien_ba.I);
        thien_ba.J = false;
        this.a.selectControl(thien_ba.g(this.a));
        thien_ba.a(this.a);
        thien_ba.I.setText("");
    }
}
