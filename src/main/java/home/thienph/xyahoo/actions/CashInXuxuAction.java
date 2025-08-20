package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.HomeScreen;

public final class CashInXuxuAction implements IAction {
    public CashInXuxuAction() {
    }

    public final void action() {
        HomeScreen cfr_ignored_0 = GameManager.instance.homeScreen;
        HomeScreen.navigateToScreen(5000, 5018);
    }
}
