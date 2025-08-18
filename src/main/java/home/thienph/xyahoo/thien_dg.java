package home.thienph.xyahoo;

final class thien_dg
implements IAction {
    private LoginScreen a;

    thien_dg(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.closeChatBox(this.a);
        thien_di.getInstance().a(this.a.mainMenu, 0);
    }
}
