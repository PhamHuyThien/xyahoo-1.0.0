package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginYahooScreen;

import javax.microedition.lcdui.Image;

public final class YahooStatusAction implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public YahooStatusAction(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        if (!this.loginYahooScreen.shouldSignOut) {
            GameManager.instance.showNotification(TextConstant.pleaseWait(), (Image)null, 1);
            return;
        }
        LoginYahooScreen.showInviteDialog(this.loginYahooScreen);
    }
}
