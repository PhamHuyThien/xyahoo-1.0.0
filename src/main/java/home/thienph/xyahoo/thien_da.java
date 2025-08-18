package home.thienph.xyahoo;

final class thien_da
        implements IAction {
    private LoginScreen a;

    thien_da(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        this.a.addControl(this.a.chatBoxField);
        this.a.selectControl(this.a.chatBoxField);
    }
}
