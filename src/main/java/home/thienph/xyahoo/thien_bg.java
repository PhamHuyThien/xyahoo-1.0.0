package home.thienph.xyahoo;

final class thien_bg
implements IAction {
    private BigTwoGameScreen a;
    private final GameBoardControl b;

    thien_bg(BigTwoGameScreen bigTwoGameScreen2, GameBoardControl gameBoardControl2) {
        this.a = bigTwoGameScreen2;
        this.b = gameBoardControl2;
    }

    public final void action() {
        if (this.b.isMyTurn) {
            this.b.isMyTurn = false;
        }
        if (BigTwoGameScreen.currentGroupName.equals(this.a.currentPlayerName)) {
            this.a.gameBoardControl.isGameStarted = true;
            MessageHandler.d(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
        }
    }
}
