package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class UpdateAction
implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public UpdateAction(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        if (BigTwoGameScreen.selectedTableType == 1) {
            UpdateAction updateAction2 = this;
            updateAction2.bigTwoGameScreen.leaveGame();
            return;
        }
        BigTwoGameScreen.exitGame(BigTwoGameScreen.selectedTableType);
    }
}
