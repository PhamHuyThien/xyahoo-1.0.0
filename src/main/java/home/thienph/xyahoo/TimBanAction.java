package home.thienph.xyahoo;

final class TimBanAction
implements IAction {
    TimBanAction(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        if (BigTwoGameScreen.selectedTableType == 1) {
            MessageHandler.d(BigTwoGameScreen.currentRoomName);
            return;
        }
        MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.currentRoomName);
    }
}
