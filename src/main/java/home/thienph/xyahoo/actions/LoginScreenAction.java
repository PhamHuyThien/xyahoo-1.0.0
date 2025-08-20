package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class LoginScreenAction
implements IAction {
    private LoginScreen loginScreen;

    public LoginScreenAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        GameManager.instance.isLoggedIn = false;
        this.loginScreen.login();
    }
}
