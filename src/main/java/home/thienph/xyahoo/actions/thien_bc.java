package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bc implements IAction {
    public thien_bc(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, false);
    }
}
