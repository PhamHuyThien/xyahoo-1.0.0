package home.thienph.xyahoo;

final class thien_fl
implements IAction {
    private final Screen a;

    thien_fl(thien_ff thien_ff2, Screen screen2) {
        this.a = screen2;
    }

    public final void action() {
        thien_di.getInstance().c(this.a);
        thien_di.instance.l();
    }
}
