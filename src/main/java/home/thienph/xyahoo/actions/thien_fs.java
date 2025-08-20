package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fs
implements IAction {
    private final thien_cl a;

    public thien_fs(BuddyListScreen buddyListScreen2, thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.a.textField.getText().trim();
        if (string.trim().equals("")) {
            return;
        }
        GameManager.getInstance().removeScreen(this.a);
        BuddyListScreen.userFullName = string;
        BuddyListScreen.userStatusMessage = BuddyListScreen.userFullName.equals("") ? BuddyListScreen.currentGroupName : BuddyListScreen.userFullName;
        MessageHandler.b(string, "", "");
        GameManager.instance.focusBuddyList();
    }
}
