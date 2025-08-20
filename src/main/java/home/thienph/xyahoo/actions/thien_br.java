package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_br
implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_br(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        this.bigTwoGameScreen.addControl(BigTwoGameScreen.getBetTextField());
        this.bigTwoGameScreen.selectControl(BigTwoGameScreen.getBetTextField());
        BigTwoGameScreen.isChatting = true;
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
    }
}
