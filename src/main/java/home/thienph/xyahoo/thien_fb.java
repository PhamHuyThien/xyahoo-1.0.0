package home.thienph.xyahoo;

final class thien_fb
implements IAction {
    private thien_ew a;

    thien_fb(thien_ew thien_ew2) {
        this.a = thien_ew2;
    }

    public final void action() {
        if (!GameManager.o.equals("")) {
            this.a.A.insertText(GameManager.o);
        }
    }
}
