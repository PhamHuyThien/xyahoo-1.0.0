package home.thienph.xyahoo;

final class thien_bq
implements IAction {
    private BigTwoGameScreen a;

    thien_bq(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (!BigTwoGameScreen.getBetTextField().getText().equals("")) {
            long l;
            this.a.removeControl(BigTwoGameScreen.getBetTextField());
            BigTwoGameScreen.isChatting = false;
            this.a.selectControl(BigTwoGameScreen.getSelectedControl(this.a));
            try {
                l = Long.parseLong(BigTwoGameScreen.getBetTextField().getText());
            }
            catch (Exception exception) {
                return;
            }
            if (BigTwoGameScreen.selectedTableType == 1) {
                MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, this.a.currentPlayerId, l);
            } else if (BigTwoGameScreen.selectedTableType == 3) {
                MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, l);
            }
        }
        BigTwoGameScreen.adjustScrollPosition(this.a);
        BigTwoGameScreen.getBetTextField().setText("");
    }
}
