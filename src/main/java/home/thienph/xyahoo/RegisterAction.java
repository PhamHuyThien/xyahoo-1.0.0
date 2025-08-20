package home.thienph.xyahoo;

final class RegisterAction
implements IAction {
    private LoginScreen a;

    RegisterAction(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.a);
        GameManager.instance.showRegisterScreen();
    }
}
