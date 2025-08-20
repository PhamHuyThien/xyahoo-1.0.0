package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_gg
implements IAction {
    public thien_gg(BuddyListScreen buddyListScreen2) {
    }

    public final void action() {
        GameManager.getInstance().removeScreen(GameManager.instance.buddyListScreen);
    }
}
