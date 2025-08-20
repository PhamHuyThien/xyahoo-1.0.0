package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bx
implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;
    private final int b;

    public thien_bx(BigTwoGameScreen bigTwoGameScreen2, int n) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
        this.b = n;
    }

    public final void action() {
        MessageHandler.a(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, this.bigTwoGameScreen.players[this.b].playerName);
    }
}
