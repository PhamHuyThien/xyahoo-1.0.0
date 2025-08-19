package home.thienph.xyahoo;

final class thien_bp
implements IAction {
    private BigTwoGameScreen a;

    thien_bp(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.h());
        BigTwoGameScreen.H = false;
        this.a.selectControl(BigTwoGameScreen.g(this.a));
        BigTwoGameScreen.a(this.a);
        BigTwoGameScreen.h().setText("");
    }
}
