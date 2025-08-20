package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class thien_gq
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public thien_gq(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        this.loginYahooScreen.w.isFilterActive = !this.loginYahooScreen.w.isFilterActive;
        this.loginYahooScreen.w.c();
        this.loginYahooScreen.w.selectedGroupIndex = 0;
        Xuka.saveFlag("hideOffline", this.loginYahooScreen.w.isFilterActive);
    }
}
