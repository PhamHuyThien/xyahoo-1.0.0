package home.thienph.xyahoo;

final class thien_ek
implements IAction {
    thien_ek(RegisterScreen registerScreen2) {
    }

    public final void action() {
        ConnectionManager.disconnect();
        GameManager.getInstance().closeTopDialog();
    }
}
