package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bp implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bp(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        this.bigTwoGameScreen.removeControl(BigTwoGameScreen.getBetTextField());
        BigTwoGameScreen.isChatting = false;
        this.bigTwoGameScreen.selectControl(BigTwoGameScreen.getSelectedControl(this.bigTwoGameScreen));
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
        BigTwoGameScreen.getBetTextField().setText("");
    }
}
