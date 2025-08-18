package home.thienph.xyahoo;

final class thien_dw
implements IAction {
    private GameManager a;
    private final TextField b;
    private final Screen c;
    private final thien_z d;

    thien_dw(GameManager gameManager2, TextField textField2, Screen screen2, thien_z thien_z2) {
        this.a = gameManager2;
        this.b = textField2;
        this.c = screen2;
        this.d = thien_z2;
    }

    public final void action() {
        String string = this.b.getText();
        if (string.equals("")) {
            this.c.selectControl(this.b);
            return;
        }
        GameManager.t.addElement(string);
        MessageHandler.i(thien_ff.y, string);
        int n = 0;
        while (n < this.d.a.length) {
            if (string.equals(this.d.a[n])) {
                this.a.b(String.valueOf(TextConstant.deleteSuccess()) + string);
                this.a.c(this.c);
                this.a.k();
                return;
            }
            ++n;
        }
        this.a.b(String.valueOf(TextConstant.add2()) + string + TextConstant.success());
        this.a.c(this.c);
        this.a.k();
    }
}
