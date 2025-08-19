package home.thienph.xyahoo;

final class TimBanAction
implements IAction {
    TimBanAction(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        if (BigTwoGameScreen.ah == 1) {
            MessageHandler.d(BigTwoGameScreen.ai);
            return;
        }
        MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.ai);
    }
}
