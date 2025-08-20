package home.thienph.xyahoo;

final class thien_bx
implements IAction {
    private BigTwoGameScreen a;
    private final int b;

    thien_bx(BigTwoGameScreen bigTwoGameScreen2, int n) {
        this.a = bigTwoGameScreen2;
        this.b = n;
    }

    public final void action() {
        MessageHandler.a(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName, this.a.players[this.b].playerName);
    }
}
