package home.thienph.xyahoo;

final class thien_gz
implements IAction {
    private LoginYahooScreen a;

    thien_gz(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        this.a.f();
    }
}
