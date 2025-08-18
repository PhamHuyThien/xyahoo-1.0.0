package home.thienph.xyahoo;

final class thien_ei
implements IAction {
    private thien_eh a;

    thien_ei(thien_eh thien_eh2) {
        this.a = thien_eh2;
    }

    public final void action() {
        this.a.f();
    }
}
