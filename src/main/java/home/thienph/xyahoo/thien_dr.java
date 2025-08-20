package home.thienph.xyahoo;

final class thien_dr
implements IAction {
    private GameManager a;
    private final TextField b;
    private final String c;
    private final FormScreen d;

    thien_dr(GameManager gameManager2, TextField textField2, String string, FormScreen formScreen2) {
        this.a = gameManager2;
        this.b = textField2;
        this.c = string;
        this.d = formScreen2;
    }

    public final void action() {
        MessageHandler.a(false, this.b.getText(), this.c);
        this.a.removeScreen(this.d);
    }
}
