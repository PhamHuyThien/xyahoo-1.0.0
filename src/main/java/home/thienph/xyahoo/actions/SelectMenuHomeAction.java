package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.HomeScreen;
import home.thienph.xyahoo.components.UIGridMenu;

public final class SelectMenuHomeAction
implements IAction {
    private HomeScreen homeScreen;

    public SelectMenuHomeAction(HomeScreen homeScreen2) {
        this.homeScreen = homeScreen2;
    }

    public final void action() {
        UIGridMenu UIGridMenu2 = this.homeScreen.homeGridMenu;
        int n = UIGridMenu2.selectedRow * UIGridMenu2.columns + UIGridMenu2.selectedCol;
        this.homeScreen.openMenuByIndex(n);
    }
}
