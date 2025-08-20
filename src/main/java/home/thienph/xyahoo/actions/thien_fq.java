package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fq
implements IAction {
    private BuddyListScreen buddyListScreen;
    private final thien_cl b;

    public thien_fq(BuddyListScreen buddyListScreen2, thien_cl thien_cl2) {
        this.buddyListScreen = buddyListScreen2;
        this.b = thien_cl2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.b.textField.getText().trim();
        if (string.equals("")) {
            return;
        }
        GameManager.getInstance().removeScreen(this.b);
        this.buddyListScreen.handleChatAction(string, 0);
    }
}
