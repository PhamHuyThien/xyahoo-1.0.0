package home.thienph.xyahoo;

final class LoginScreenAction
implements IAction {
    private LoginScreen loginScreen;

    LoginScreenAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        GameManager.instance.isLoggedIn = false;
        this.loginScreen.login();
    }
}
