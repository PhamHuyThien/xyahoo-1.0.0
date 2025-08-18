package home.thienph.xyahoo;

final class thien_dt
implements IAction {
    private thien_di a;
    private final FormScreen b;

    thien_dt(thien_di thien_di2, FormScreen formScreen2) {
        this.a = thien_di2;
        this.b = formScreen2;
    }

    public final void action() {
        this.a.c(this.b);
    }
}
