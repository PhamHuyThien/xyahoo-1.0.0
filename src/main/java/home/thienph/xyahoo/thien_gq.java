package home.thienph.xyahoo;

final class thien_gq
implements IAction {
    private LoginYahooScreen a;

    thien_gq(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        this.a.w.d = !this.a.w.d;
        this.a.w.c();
        this.a.w.h = 0;
        Xuka.saveFlag("hideOffline", this.a.w.d);
    }
}
