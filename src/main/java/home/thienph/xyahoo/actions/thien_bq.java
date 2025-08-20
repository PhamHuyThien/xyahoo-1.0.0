package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bq
implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bq(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        if (!BigTwoGameScreen.getBetTextField().getText().equals("")) {
            long l;
            this.bigTwoGameScreen.removeControl(BigTwoGameScreen.getBetTextField());
            BigTwoGameScreen.isChatting = false;
            this.bigTwoGameScreen.selectControl(BigTwoGameScreen.getSelectedControl(this.bigTwoGameScreen));
            try {
                l = Long.parseLong(BigTwoGameScreen.getBetTextField().getText());
            }
            catch (Exception exception) {
                return;
            }
            if (BigTwoGameScreen.selectedTableType == 1) {
                MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, this.bigTwoGameScreen.currentPlayerId, l);
            } else if (BigTwoGameScreen.selectedTableType == 3) {
                MessageHandler.a(BigTwoGameScreen.selectedTableType, BigTwoGameScreen.gameRoomId, l);
            }
        }
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
        BigTwoGameScreen.getBetTextField().setText("");
    }
}
