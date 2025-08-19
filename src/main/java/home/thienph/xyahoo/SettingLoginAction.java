package home.thienph.xyahoo;

final class SettingLoginAction
implements IAction {
    private LoginScreen loginScreen;

    SettingLoginAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        LoginScreen.openSettings();
    }
}
