package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class LogoutYahooAction
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public LogoutYahooAction(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        this.loginYahooScreen.cleanup();
    }
}
