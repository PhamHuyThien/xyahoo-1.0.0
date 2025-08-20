package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;
import home.thienph.xyahoo.managers.MessageHandler;

public final class TimBanAction
implements IAction {
    public TimBanAction(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        if (BigTwoGameScreen.selectedTableType == 1) {
            MessageHandler.d(BigTwoGameScreen.currentRoomName);
            return;
        }
        MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.currentRoomName);
    }
}
