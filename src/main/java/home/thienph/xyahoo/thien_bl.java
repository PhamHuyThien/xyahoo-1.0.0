package home.thienph.xyahoo;

final class thien_bl
implements IAction {
    private BigTwoGameScreen a;

    thien_bl(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        GameBoardControl.isShowingAllCards = false;
        if (!this.a.isSpectatorMode) {
            this.a.prepareNextRound();
        }
        long cfr_ignored_0 = this.a.resultTimestamp;
        this.a.initializeGameSession((byte)this.a.activePlayerCount, this.a.resultPlayerNames, this.a.resultPlayerScores, this.a.resultPlayerCards, this.a.resultPlayerStatuses, this.a.resultPlayerRanks, this.a.resultPlayerRewards, BigTwoGameScreen.gameRoomId);
    }
}
