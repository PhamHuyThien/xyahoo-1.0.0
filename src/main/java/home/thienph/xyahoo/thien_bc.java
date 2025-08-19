package home.thienph.xyahoo;

final class thien_bc
implements IAction {
    thien_bc(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.B, BigTwoGameScreen.currentGroupName, false);
    }
}
