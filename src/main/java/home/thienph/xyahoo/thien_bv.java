package home.thienph.xyahoo;

final class thien_bv
implements IAction {
    private BigTwoGameScreen a;

    thien_bv(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        GameManager.getInstance().showPopupSideLayout(BigTwoGameScreen.b(this.a), 0);
        BigTwoGameScreen.a(this.a);
    }
}
