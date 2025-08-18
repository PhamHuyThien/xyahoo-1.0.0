package home.thienph.xyahoo;

final class thien_dk
implements IAction {
    private thien_di a;

    thien_dk(thien_di thien_di2) {
        this.a = thien_di2;
    }

    public final void action() {
        this.a.c();
    }
}
