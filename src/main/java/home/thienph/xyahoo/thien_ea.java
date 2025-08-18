package home.thienph.xyahoo;

final class thien_ea
implements IAction {
    private GameManager a;

    thien_ea(GameManager gameManager2) {
        this.a = gameManager2;
    }

    public final void action() {
        this.a.c();
    }
}
