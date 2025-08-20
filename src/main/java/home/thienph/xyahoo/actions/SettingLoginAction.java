package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginScreen;

public final class SettingLoginAction
implements IAction {
    private LoginScreen loginScreen;

    public SettingLoginAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        LoginScreen.openSettings();
    }
}
