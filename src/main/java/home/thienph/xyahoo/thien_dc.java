package home.thienph.xyahoo;

final class thien_dc
implements IAction {
    private LoginScreen a;

    thien_dc(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.closeChatBox(this.a);
        thien_di.instance.e();
    }
}
