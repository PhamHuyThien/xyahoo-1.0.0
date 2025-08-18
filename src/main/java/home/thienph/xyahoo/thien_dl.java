package home.thienph.xyahoo;

final class thien_dl
implements IAction {
    private GameManager a;

    thien_dl(GameManager gameManager2) {
        this.a = gameManager2;
    }

    public final void action() {
        this.a.c();
    }
}
