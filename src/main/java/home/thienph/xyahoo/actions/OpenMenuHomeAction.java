package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.HomeScreen;

public final class OpenMenuHomeAction
implements IAction {
    private HomeScreen homeScreen;

    public OpenMenuHomeAction(HomeScreen homeScreen2) {
        this.homeScreen = homeScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.homeScreen.E, 0);
    }
}
