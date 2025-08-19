package home.thienph.xyahoo;

final class thien_bm
implements IAction {
    private BigTwoGameScreen a;

    thien_bm(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.addControl(BigTwoGameScreen.I);
        BigTwoGameScreen.J = true;
        this.a.selectControl(BigTwoGameScreen.I);
        BigTwoGameScreen.a(this.a);
    }
}
