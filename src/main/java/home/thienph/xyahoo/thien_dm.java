package home.thienph.xyahoo;

final class thien_dm
implements IAction {
    final thien_di a;
    private final String b;
    private final IAction c;

    thien_dm(thien_di thien_di2, String string, IAction IAction2) {
        this.a = thien_di2;
        this.b = string;
        this.c = IAction2;
    }

    public final void action() {
        this.a.c();
        Xuka.startThread(this.b, this.a.v(), new thien_dn(this), new thien_do(this, this.c), false);
    }
}
