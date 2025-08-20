package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bv implements IAction {
    private BigTwoGameScreen bigTwoGameScreen;

    public thien_bv(BigTwoGameScreen bigTwoGameScreen2) {
        this.bigTwoGameScreen = bigTwoGameScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(BigTwoGameScreen.getGameMenuData(this.bigTwoGameScreen), 0);
        BigTwoGameScreen.adjustScrollPosition(this.bigTwoGameScreen);
    }
}
