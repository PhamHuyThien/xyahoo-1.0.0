package home.thienph.xyahoo;

final class thien_bk
implements IAction {
    thien_bk(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        GameManager.getInstance().closeTopDialog();
    }
}
