package home.thienph.xyahoo;

final class thien_dx
implements IAction {
    private thien_di a;
    private final Screen b;

    thien_dx(thien_di thien_di2, Screen screen2) {
        this.a = thien_di2;
        this.b = screen2;
    }

    public final void action() {
        this.a.c(this.b);
        this.a.k();
    }
}
