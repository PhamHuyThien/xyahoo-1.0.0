package home.thienph.xyahoo;

final class thien_dh
implements IAction {
    private LoginScreen a;
    private final TextField b;

    thien_dh(LoginScreen loginScreen2, TextField textField2) {
        this.a = loginScreen2;
        this.b = textField2;
    }

    public final void action() {
        this.a.removeControl(this.b);
        this.a.selectControl(this.a.usernameField);
        this.b.setText("");
    }
}
