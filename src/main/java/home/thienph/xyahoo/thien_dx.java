package home.thienph.xyahoo;

final class thien_dx
implements IAction {
    private GameManager a;
    private final Screen b;

    thien_dx(GameManager gameManager2, Screen screen2) {
        this.a = gameManager2;
        this.b = screen2;
    }

    public final void action() {
        this.a.c(this.b);
        this.a.k();
    }
}
