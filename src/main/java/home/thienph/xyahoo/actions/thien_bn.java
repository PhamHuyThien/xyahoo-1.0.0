package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bn implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bn(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        this.bigTwoGameScreen.removeControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = false;
        this.bigTwoGameScreen.selectControl(BigTwoGameScreen.getSelectedControl(this.bigTwoGameScreen));
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
        BigTwoGameScreen.chatTextField.setText("");
    }
}
