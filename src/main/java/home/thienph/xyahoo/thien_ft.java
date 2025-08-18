package home.thienph.xyahoo;

final class thien_ft
implements IAction {
    private thien_ff a;

    thien_ft(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        this.a.b("");
    }
}
