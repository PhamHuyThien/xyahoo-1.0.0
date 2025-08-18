package home.thienph.xyahoo;

final class thien_fh
implements IAction {
    private final Screen a;

    thien_fh(thien_ff thien_ff2, Screen screen2) {
        this.a = screen2;
    }

    public final void action() {
        GameManager.getInstance().c(this.a);
        GameManager.instance.l();
    }
}
