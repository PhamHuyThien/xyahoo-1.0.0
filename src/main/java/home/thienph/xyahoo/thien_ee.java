package home.thienph.xyahoo;

final class thien_ee
implements IAction {
    private GameManager a;
    private final String b;
    private final String c;
    private final String d;

    thien_ee(GameManager gameManager2, String string, String string2, String string3) {
        this.a = gameManager2;
        this.b = string;
        this.c = string2;
        this.d = string3;
    }

    public final void action() {
        MessageHandler.a(this.b, true, "", this.c);
        this.a.a(this.b, (String[])null, this.d);
        this.a.closeTopDialog();
    }
}
