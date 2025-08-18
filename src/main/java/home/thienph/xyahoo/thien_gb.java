package home.thienph.xyahoo;

final class thien_gb
implements IAction {
    private final TextField a;
    private final Screen b;

    thien_gb(thien_ff thien_ff2, TextField textField2, Screen screen2) {
        this.a = textField2;
        this.b = screen2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.a.getText().trim();
        if (string.equals("")) {
            return;
        }
        GameManager.getInstance().c(this.b);
        MessageHandler.g(string);
        GameManager.instance.l();
    }
}
