package home.thienph.xyahoo;

final class UpdateAction
implements IAction {
    private BigTwoGameScreen a;

    UpdateAction(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (BigTwoGameScreen.ah == 1) {
            UpdateAction updateAction2 = this;
            updateAction2.a.e();
            return;
        }
        BigTwoGameScreen.e(BigTwoGameScreen.ah);
    }
}
