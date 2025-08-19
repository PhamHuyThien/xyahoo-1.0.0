package home.thienph.xyahoo;

final class thien_gr
implements IAction {
    private LoginYahooScreen a;

    thien_gr(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        GameManager.getInstance().c(this.a);
    }
}
