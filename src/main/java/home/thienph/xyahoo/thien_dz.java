package home.thienph.xyahoo;

final class thien_dz
implements IAction {
    private GameManager a;
    private final String b;

    thien_dz(GameManager gameManager2, String string) {
        this.a = gameManager2;
        this.b = string;
    }

    public final void action() {
        MessageHandler.c(thien_gp.x, this.b, 0);
        this.a.c();
    }
}
