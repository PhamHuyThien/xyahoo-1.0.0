package home.thienph.xyahoo;

final class thien_bo
        implements IAction {
    private BigTwoGameScreen a;

    thien_bo(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        this.a.removeControl(BigTwoGameScreen.I);
        BigTwoGameScreen.J = false;
        this.a.selectControl(BigTwoGameScreen.g(this.a));
        if (BigTwoGameScreen.ah == 1) {
            MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.B, BigTwoGameScreen.currentGroupName, BigTwoGameScreen.I.getText());
        }
        BigTwoGameScreen.a(this.a);
        BigTwoGameScreen.I.setText("");
    }
}
