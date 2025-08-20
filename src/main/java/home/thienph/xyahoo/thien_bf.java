package home.thienph.xyahoo;

final class thien_bf
implements IAction {
    private BigTwoGameScreen a;

    thien_bf(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (this.a.centerCommand.label.equals(TextConstant.ready())) {
            int n = 0;
            while (n < this.a.players.length) {
                if (this.a.players[n].playerName.equals(BigTwoGameScreen.currentGroupName)) {
                    this.a.centerCommand.label = "";
                    MessageHandler.b(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
                }
                ++n;
            }
        }
    }
}
