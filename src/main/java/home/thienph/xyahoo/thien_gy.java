package home.thienph.xyahoo;

final class thien_gy
implements IAction {
    private LoginYahooScreen a;

    thien_gy(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.a.B, 0);
    }
}
