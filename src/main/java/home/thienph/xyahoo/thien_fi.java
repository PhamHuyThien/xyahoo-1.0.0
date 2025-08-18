package home.thienph.xyahoo;

final class thien_fi
implements IAction {
    private final thien_am a;

    thien_fi(thien_ff thien_ff2, thien_am thien_am2) {
        this.a = thien_am2;
    }

    public final void action() {
        GameManager.getInstance().a(this.a, 0);
    }
}
