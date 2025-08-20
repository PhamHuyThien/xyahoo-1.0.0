package home.thienph.xyahoo;

final class thien_cw
        implements IAction {
    private LoginScreen a;

    thien_cw(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        GameManager.instance.closeTopDialog();
        GameManager.instance.showSimpleDialog(TextConstant.pleaseWait());
        Xuka.startThread(String.valueOf(GameManager.recoveryPhone) + this.a.usernameField.getText(), GameManager.instance.getRecoveryInfo(), new thien_cx(this), null, true);
    }
}
