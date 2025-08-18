package home.thienph.xyahoo;

final class thien_db
implements IAction {
    private LoginScreen a;

    thien_db(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.closeChatBox(this.a);
        GameManager.instance.A = false;
        this.a.login();
    }
}
