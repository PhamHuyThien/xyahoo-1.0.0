package home.thienph.xyahoo;

final class thien_eb
implements IAction {
    private thien_di a;

    thien_eb(thien_di thien_di2) {
        this.a = thien_di2;
    }

    public final void action() {
        ConnectionManager.disconnect();
        this.a.c();
    }
}
