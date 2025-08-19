package home.thienph.xyahoo;

final class thien_gx
implements IAction {
    private LoginYahooScreen a;

    thien_gx(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        this.a.e();
    }
}
