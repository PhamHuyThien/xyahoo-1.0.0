package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class thien_gz
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public thien_gz(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        this.loginYahooScreen.f();
    }
}
