package home.thienph.xyahoo;

final class thien_bc
implements IAction {
    thien_bc(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, false);
    }
}
