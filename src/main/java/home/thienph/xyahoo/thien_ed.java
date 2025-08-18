package home.thienph.xyahoo;

final class thien_ed
implements IAction {
    private GameManager a;

    thien_ed(GameManager gameManager2) {
        this.a = gameManager2;
    }

    public final void action() {
        this.a.c();
    }
}
