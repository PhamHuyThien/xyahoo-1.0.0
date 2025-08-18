package home.thienph.xyahoo;

final class thien_ej
implements IAction {
    private thien_eh a;

    thien_ej(thien_eh thien_eh2) {
        this.a = thien_eh2;
    }

    public final void action() {
        this.a.g();
    }
}
