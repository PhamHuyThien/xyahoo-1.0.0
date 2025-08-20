package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.GameBoardControl;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bl
implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bl(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        GameBoardControl.isShowingAllCards = false;
        if (!this.bigTwoGameScreen.isSpectatorMode) {
            this.bigTwoGameScreen.prepareNextRound();
        }
        long cfr_ignored_0 = this.bigTwoGameScreen.resultTimestamp;
        this.bigTwoGameScreen.initializeGameSession((byte)this.bigTwoGameScreen.activePlayerCount, this.bigTwoGameScreen.resultPlayerNames, this.bigTwoGameScreen.resultPlayerScores, this.bigTwoGameScreen.resultPlayerCards, this.bigTwoGameScreen.resultPlayerStatuses, this.bigTwoGameScreen.resultPlayerRanks, this.bigTwoGameScreen.resultPlayerRewards, BigTwoGameScreen.gameRoomId);
    }
}
