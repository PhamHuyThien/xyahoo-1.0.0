package home.thienph.xyahoo;

final class thien_fz
implements IAction {
    private thien_ff a;

    thien_fz(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        thien_u thien_u2 = this.a.x.h();
        if (thien_u2 == null) {
            return;
        }
        if (thien_u2.a == 0) {
            this.a.j();
            return;
        }
        this.a.f();
    }
}
