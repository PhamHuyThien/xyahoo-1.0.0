package home.thienph.xyahoo;

final class thien_fv
implements IAction {
    private thien_ff a;

    thien_fv(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        this.a.x.d = !this.a.x.d;
        this.a.x.c();
        this.a.x.h = 0;
    }
}
