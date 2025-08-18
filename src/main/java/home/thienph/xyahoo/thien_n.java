package home.thienph.xyahoo;

final class thien_n
implements IAction {
    private final thien_am a;

    thien_n(thien_am thien_am2) {
        this.a = thien_am2;
    }

    public final void action() {
        thien_di.getInstance().a(this.a, 0);
    }
}
