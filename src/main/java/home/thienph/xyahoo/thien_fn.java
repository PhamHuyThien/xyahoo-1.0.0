package home.thienph.xyahoo;

final class thien_fn
implements IAction {
    private final TextField a;
    private final thien_z b;
    private final Screen c;

    thien_fn(thien_ff thien_ff2, TextField textField2, thien_z thien_z2, Screen screen2) {
        this.a = textField2;
        this.b = thien_z2;
        this.c = screen2;
    }

    public final void action() {
        String string = thien_fe.b(this.a.getText().trim());
        int n = this.b.a() == 0 ? 1 : 0;
        if (n != thien_ff.B) {
            MessageHandler.a(n, 1);
            thien_ff.B = n;
        }
        if (thien_ff.B == 1) {
            MessageHandler.a(string, 1);
            thien_ff.D = string;
            Xuka.saveCustomStr(thien_ff.y, thien_ff.D, false);
        }
        GameManager.getInstance().c(this.c);
        GameManager.instance.l();
    }
}
