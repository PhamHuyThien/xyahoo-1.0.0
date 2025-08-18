package home.thienph.xyahoo;

final class thien_gm
implements IAction {
    private final TextField a;
    private final thien_z b;
    private final Screen c;

    thien_gm(thien_ff thien_ff2, TextField textField2, thien_z thien_z2, Screen screen2) {
        this.a = textField2;
        this.b = thien_z2;
        this.c = screen2;
    }

    public final void action() {
        String string = this.a.getText().trim();
        if (string.equals("")) {
            return;
        }
        String string2 = this.b.b();
        MessageHandler.j(string2, string);
        GameManager.getInstance().c(this.c);
        GameManager.instance.l();
    }
}
