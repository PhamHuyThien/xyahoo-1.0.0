package home.thienph.xyahoo;

final class thien_bp
implements IAction {
    private BigTwoGameScreen a;

    thien_bp(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.getBetTextField());
        BigTwoGameScreen.isChatting = false;
        this.a.selectControl(BigTwoGameScreen.getSelectedControl(this.a));
        BigTwoGameScreen.adjustScrollPosition(this.a);
        BigTwoGameScreen.getBetTextField().setText("");
    }
}
