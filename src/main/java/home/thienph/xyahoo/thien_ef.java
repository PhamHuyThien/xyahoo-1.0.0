package home.thienph.xyahoo;

final class thien_ef
implements IAction {
    private GameManager a;
    private final String b;
    private final String c;

    thien_ef(GameManager gameManager2, String string, String string2) {
        this.a = gameManager2;
        this.b = string;
        this.c = string2;
    }

    public final void action() {
        MessageHandler.a(this.b, false, "", this.c);
        this.a.c();
    }
}
