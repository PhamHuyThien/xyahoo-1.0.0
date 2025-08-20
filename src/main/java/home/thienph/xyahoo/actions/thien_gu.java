package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class thien_gu
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public thien_gu(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(LoginYahooScreen.d(this.loginYahooScreen));
    }
}
