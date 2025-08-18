package home.thienph.xyahoo;

final class thien_dl
implements IAction {
    private thien_di a;

    thien_dl(thien_di thien_di2) {
        this.a = thien_di2;
    }

    public final void action() {
        this.a.c();
    }
}
