package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.LoginYahooScreen;
import home.thienph.xyahoo.utils.ContentFilter;

public final class thien_gt
implements IAction {
    private LoginYahooScreen loginYahooScreen;

    public thien_gt(LoginYahooScreen loginYahooScreen2) {
        this.loginYahooScreen = loginYahooScreen2;
    }

    public final void action() {
        int n;
        String string = ContentFilter.filterProfanity(LoginYahooScreen.b(this.loginYahooScreen).getText().trim());
        int n2 = n = LoginYahooScreen.c(this.loginYahooScreen).getSelectedIndex() == 0 ? 0 : 12;
        if (string != null && !string.equals(LoginYahooScreen.A)) {
            LoginYahooScreen.a(this.loginYahooScreen, string);
            LoginYahooScreen.z = 0;
            GameManager.isShowingAnimation = true;
        } else if (n != LoginYahooScreen.z) {
            if (n == 0) {
                if (string != null && string.length() > 0) {
                    LoginYahooScreen.a(this.loginYahooScreen, string);
                } else {
                    MessageHandler.a(0, 2);
                }
                LoginYahooScreen.z = 0;
                GameManager.isShowingAnimation = true;
            } else {
                MessageHandler.a(12, 2);
                LoginYahooScreen.z = 12;
                GameManager.isShowingAnimation = true;
            }
        }
        GameManager.getInstance().removeScreen(LoginYahooScreen.d(this.loginYahooScreen));
    }
}
