package home.thienph.xyahoo;

final class SettingAction
implements IAction {
    private LoginScreen loginScreen;

    SettingAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        LoginScreen.openSettings();
    }
}
