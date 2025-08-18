package home.thienph.xyahoo;

final class thien_ek
implements IAction {
    thien_ek(thien_eh thien_eh2) {
    }

    public final void action() {
        ConnectionManager.disconnect();
        GameManager.getInstance().c();
    }
}
