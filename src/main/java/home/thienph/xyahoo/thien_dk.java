package home.thienph.xyahoo;

final class thien_dk
implements IAction {
    private GameManager a;

    thien_dk(GameManager gameManager2) {
        this.a = gameManager2;
    }

    public final void action() {
        this.a.closeTopDialog();
    }
}
