package home.thienph.xyahoo;

final class thien_de
implements IAction {
    private LoginScreen a;

    thien_de(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.closeChatBox(this.a);
        LoginScreen.openSettings();
    }
}
