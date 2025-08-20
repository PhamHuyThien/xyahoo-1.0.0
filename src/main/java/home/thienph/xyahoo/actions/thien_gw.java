package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginYahooScreen;

import javax.microedition.lcdui.Image;

public final class thien_gw
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public thien_gw(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        if (!this.loginYahooScreen.C) {
            GameManager.instance.showNotification(TextConstant.pleaseWait(), (Image)null, 1);
            return;
        }
        this.loginYahooScreen.h();
    }
}
