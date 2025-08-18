package home.thienph.xyahoo;

final class thien_cw
        implements IAction {
    private LoginScreen a;

    thien_cw(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        thien_di.instance.c();
        thien_di.instance.b(TextConstant.pleaseWait());
        Xuka.startThread(String.valueOf(thien_di.D) + this.a.usernameField.getText(), thien_di.instance.w(), new thien_cx(this), null, true);
    }
}
