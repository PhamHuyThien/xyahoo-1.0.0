package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class ClickMenuYahooLoginAction
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public ClickMenuYahooLoginAction(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.loginYahooScreen.popupMenuData, 0);
    }
}
