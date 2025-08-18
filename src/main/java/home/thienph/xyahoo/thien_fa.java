package home.thienph.xyahoo;

final class thien_fa
implements IAction {
    private thien_ew a;

    thien_fa(thien_ew thien_ew2) {
        this.a = thien_ew2;
    }

    public final void action() {
        String string = this.a.z.d();
        if (!string.equals("")) {
            GameManager.o = string;
        }
    }
}
