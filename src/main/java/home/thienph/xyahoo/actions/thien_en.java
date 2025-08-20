package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.HomeScreen;

public final class thien_en
implements IAction {
    public thien_en() {
    }

    public final void action() {
        HomeScreen cfr_ignored_0 = GameManager.instance.homeScreen;
        HomeScreen.f(5000, 5018);
    }
}
