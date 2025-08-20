package home.thienph.xyahoo;

final class thien_bm
implements IAction {
    private BigTwoGameScreen a;

    thien_bm(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.addControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = true;
        this.a.selectControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.adjustScrollPosition(this.a);
    }
}
