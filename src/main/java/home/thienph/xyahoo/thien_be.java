package home.thienph.xyahoo;

final class thien_be
implements IAction {
    private BigTwoGameScreen a;

    thien_be(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (this.a.centerCommand.label.equals(TextConstant.playNow())) {
            MessageHandler.c(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
        }
    }
}
