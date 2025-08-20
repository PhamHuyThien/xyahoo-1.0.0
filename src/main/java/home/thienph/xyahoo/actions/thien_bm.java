package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bm implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bm(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        this.bigTwoGameScreen.addControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = true;
        this.bigTwoGameScreen.selectControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
    }
}
