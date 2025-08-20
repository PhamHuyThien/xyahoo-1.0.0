package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_fl
implements IAction {
    private final Screen screen;

    public thien_fl(BuddyListScreen buddyListScreen2, Screen screen2) {
        this.screen = screen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.screen);
        GameManager.instance.focusBuddyList();
    }
}
