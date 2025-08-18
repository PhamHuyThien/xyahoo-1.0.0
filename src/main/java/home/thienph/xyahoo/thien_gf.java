package home.thienph.xyahoo;

final class thien_gf
implements IAction {
    private thien_ff a;

    thien_gf(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        this.a.i();
    }
}
