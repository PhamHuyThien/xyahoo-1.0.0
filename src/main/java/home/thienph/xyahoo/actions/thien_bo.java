package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bo
        implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bo(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        this.bigTwoGameScreen.removeControl(BigTwoGameScreen.chatTextField);
        BigTwoGameScreen.isChatVisible = false;
        this.bigTwoGameScreen.selectControl(BigTwoGameScreen.getSelectedControl(this.bigTwoGameScreen));
        if (BigTwoGameScreen.selectedTableType == 1) {
            MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, BigTwoGameScreen.chatTextField.getText());
        }
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
        BigTwoGameScreen.chatTextField.setText("");
    }
}
