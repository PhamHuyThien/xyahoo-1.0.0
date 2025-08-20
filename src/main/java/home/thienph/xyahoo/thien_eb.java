package home.thienph.xyahoo;

final class thien_eb
implements IAction {
    private GameManager a;

    thien_eb(GameManager gameManager2) {
        this.a = gameManager2;
    }

    public final void action() {
        ConnectionManager.disconnect();
        this.a.closeTopDialog();
    }
}
