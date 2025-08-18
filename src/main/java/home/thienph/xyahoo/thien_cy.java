package home.thienph.xyahoo;

final class thien_cy
implements IAction {
    thien_cy(LoginScreen loginScreen2) {
    }

    public final void action() {
        ConnectionManager.disconnect();
        thien_di.getInstance().c();
    }
}
