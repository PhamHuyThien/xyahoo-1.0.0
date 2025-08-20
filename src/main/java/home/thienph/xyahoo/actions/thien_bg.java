package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.GameBoardControl;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bg implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;
    private final GameBoardControl gameBoardControl;

    public thien_bg(BigTwoGameScreen bigTwoGameScreen2, GameBoardControl gameBoardControl2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
        this.gameBoardControl = gameBoardControl2;
    }

    public final void action() {
        if (this.gameBoardControl.isMyTurn) {
            this.gameBoardControl.isMyTurn = false;
        }
        if (BigTwoGameScreen.currentGroupName.equals(this.bigTwoGameScreen.currentPlayerName)) {
            this.bigTwoGameScreen.gameBoardControl.isGameStarted = true;
            MessageHandler.d(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
        }
    }
}
