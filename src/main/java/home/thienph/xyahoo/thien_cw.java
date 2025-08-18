package home.thienph.xyahoo;

final class thien_cw
        implements IAction {
    private LoginScreen a;

    thien_cw(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        GameManager.instance.c();
        GameManager.instance.b(TextConstant.pleaseWait());
        Xuka.startThread(String.valueOf(GameManager.D) + this.a.usernameField.getText(), GameManager.instance.w(), new thien_cx(this), null, true);
    }
}
