package home.thienph.xyahoo;

final class thien_fx
implements IAction {
    private thien_ff a;

    thien_fx(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        this.a.m();
    }
}
