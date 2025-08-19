package home.thienph.xyahoo;

final class thien_bd
implements IAction {
    private BigTwoGameScreen a;

    thien_bd(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        GameManager.getInstance().showPopupSideLayout(BigTwoGameScreen.c(this.a), 0);
    }
}
