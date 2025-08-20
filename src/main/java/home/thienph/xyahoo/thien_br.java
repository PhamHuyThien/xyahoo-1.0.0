package home.thienph.xyahoo;

final class thien_br
implements IAction {
    private BigTwoGameScreen a;

    thien_br(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.addControl(BigTwoGameScreen.getBetTextField());
        this.a.selectControl(BigTwoGameScreen.getBetTextField());
        BigTwoGameScreen.isChatting = true;
        BigTwoGameScreen.adjustScrollPosition(this.a);
    }
}
