package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_be implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_be(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        if (this.bigTwoGameScreen.centerCommand.label.equals(TextConstant.playNow())) {
            MessageHandler.c(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
        }
    }
}
