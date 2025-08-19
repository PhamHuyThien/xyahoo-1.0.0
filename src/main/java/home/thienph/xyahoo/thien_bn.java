package home.thienph.xyahoo;

final class thien_bn
implements IAction {
    private BigTwoGameScreen a;

    thien_bn(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.I);
        BigTwoGameScreen.J = false;
        this.a.selectControl(BigTwoGameScreen.g(this.a));
        BigTwoGameScreen.a(this.a);
        BigTwoGameScreen.I.setText("");
    }
}
