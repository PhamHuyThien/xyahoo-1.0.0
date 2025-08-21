package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class ClickLoginYahooAction implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public ClickLoginYahooAction(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        this.loginYahooScreen.performLogin();
    }
}
