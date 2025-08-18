package home.thienph.xyahoo;

final class thien_ez
implements IAction {
    private thien_ew a;

    thien_ez(thien_ew thien_ew2) {
        this.a = thien_ew2;
    }

    public final void action() {
        GameManager.getInstance().m.w = this.a.subtitle;
        GameManager.getInstance().h();
    }
}
