package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bf implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bf(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        if (this.bigTwoGameScreen.centerCommand.label.equals(TextConstant.ready())) {
            int n = 0;
            while (n < this.bigTwoGameScreen.players.length) {
                if (this.bigTwoGameScreen.players[n].playerName.equals(BigTwoGameScreen.currentGroupName)) {
                    this.bigTwoGameScreen.centerCommand.label = "";
                    MessageHandler.b(BigTwoGameScreen.gameRoomId, BigTwoGameScreen.currentGroupName);
                }
                ++n;
            }
        }
    }
}
