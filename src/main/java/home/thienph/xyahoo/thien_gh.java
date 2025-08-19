package home.thienph.xyahoo;

final class thien_gh
implements IAction {
    private thien_ff a;

    thien_gh(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void action() {
        GameManager.getInstance().showPopupSideLayout(this.a.I, 0);
    }
}
