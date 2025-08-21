package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class YahooShowHideOfflineAction
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public YahooShowHideOfflineAction(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        this.loginYahooScreen.buddyListControl.isFilterActive = !this.loginYahooScreen.buddyListControl.isFilterActive;
        this.loginYahooScreen.buddyListControl.rebuildVisibleItems();
        this.loginYahooScreen.buddyListControl.selectedItemIndex = 0;
        Xuka.saveFlag("hideOffline", this.loginYahooScreen.buddyListControl.isFilterActive);
    }
}
