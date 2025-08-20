package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class MenuLoginAction
implements IAction {
    private LoginScreen loginScreen;

    public MenuLoginAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        GameManager.getInstance().showSideMenu(this.loginScreen.menuPopupSide, 0);
    }
}
