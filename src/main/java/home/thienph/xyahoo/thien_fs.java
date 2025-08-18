package home.thienph.xyahoo;

final class thien_fs
implements IAction {
    private final thien_cl a;

    thien_fs(thien_ff thien_ff2, thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.a.D.getText().trim();
        if (string.trim().equals("")) {
            return;
        }
        thien_di.getInstance().c(this.a);
        thien_ff.z = string;
        thien_ff.A = thien_ff.z.equals("") ? thien_ff.y : thien_ff.z;
        MessageHandler.b(string, "", "");
        thien_di.instance.l();
    }
}
