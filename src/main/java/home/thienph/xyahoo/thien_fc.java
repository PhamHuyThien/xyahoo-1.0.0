package home.thienph.xyahoo;

final class thien_fc
implements IAction {
    private thien_ew a;
    private final boolean b;

    thien_fc(thien_ew thien_ew2, boolean bl) {
        this.a = thien_ew2;
        this.b = bl;
    }

    public final void action() {
        if (this.b) {
            MessageHandler.h(this.a.subtitle);
        }
        GameManager.getInstance().c(this.a);
    }
}
