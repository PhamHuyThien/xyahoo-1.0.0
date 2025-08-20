package home.thienph.xyahoo;

final class thien_gu
implements IAction {
    private LoginYahooScreen a;

    thien_gu(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(LoginYahooScreen.d(this.a));
    }
}
