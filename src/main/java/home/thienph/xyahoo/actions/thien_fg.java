package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fg
implements IAction {
    private BuddyListScreen buddyListScreen;
    private final thien_cl b;
    private final String c;

    public thien_fg(BuddyListScreen buddyListScreen2, thien_cl thien_cl2, String string) {
        this.buddyListScreen = buddyListScreen2;
        this.b = thien_cl2;
        this.c = string;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.b.textField.getText().trim();
        if (string.equals("")) {
            return;
        }
        if (this.buddyListScreen.buddyList.c(string)) {
            GameManager.getInstance().showSimpleDialog(TextConstant.thisGroupNameAlreadyExist());
            return;
        }
        MessageHandler.h(this.c, string);
        GameManager.getInstance().removeScreen(this.b);
        GameManager.instance.focusBuddyList();
    }
}
