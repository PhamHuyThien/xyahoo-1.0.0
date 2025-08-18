package home.thienph.xyahoo;

final class thien_gq
implements IAction {
    private thien_gp a;

    thien_gq(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        this.a.w.d = !this.a.w.d;
        this.a.w.c();
        this.a.w.h = 0;
        Xuka.saveFlag("hideOffline", this.a.w.d);
    }
}
