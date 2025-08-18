package home.thienph.xyahoo;

final class thien_dt
implements IAction {
    private GameManager a;
    private final FormScreen b;

    thien_dt(GameManager gameManager2, FormScreen formScreen2) {
        this.a = gameManager2;
        this.b = formScreen2;
    }

    public final void action() {
        this.a.c(this.b);
    }
}
