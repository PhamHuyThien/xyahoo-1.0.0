package home.thienph.xyahoo;

final class thien_fg
implements IAction {
    private thien_ff a;
    private final thien_cl b;
    private final String c;

    thien_fg(thien_ff thien_ff2, thien_cl thien_cl2, String string) {
        this.a = thien_ff2;
        this.b = thien_cl2;
        this.c = string;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.b.D.getText().trim();
        if (string.equals("")) {
            return;
        }
        if (this.a.x.c(string)) {
            GameManager.getInstance().b(TextConstant.thisGroupNameAlreadyExist());
            return;
        }
        MessageHandler.h(this.c, string);
        GameManager.getInstance().c(this.b);
        GameManager.instance.l();
    }
}
