package home.thienph.xyahoo;

final class UpdateAction
implements IAction {
    private BigTwoGameScreen a;

    UpdateAction(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (BigTwoGameScreen.selectedTableType == 1) {
            UpdateAction updateAction2 = this;
            updateAction2.a.leaveGame();
            return;
        }
        BigTwoGameScreen.exitGame(BigTwoGameScreen.selectedTableType);
    }
}
