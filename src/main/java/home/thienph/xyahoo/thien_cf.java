package home.thienph.xyahoo;

final class thien_cf
implements IAction {
    private thien_ce a;

    thien_cf(thien_ce thien_ce2) {
        this.a = thien_ce2;
    }

    public final void action() {
        thien_ce thien_ce2 = this.a;
        thien_ca.a(thien_ce2.a);
    }
}
