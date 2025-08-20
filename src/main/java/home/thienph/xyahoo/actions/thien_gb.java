package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_gb
implements IAction {
    private final TextField textField;
    private final Screen screen;

    public thien_gb(BuddyListScreen buddyListScreen2, TextField textField2, Screen screen2) {
        this.textField = textField2;
        this.screen = screen2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.textField.getText().trim();
        if (string.equals("")) {
            return;
        }
        GameManager.getInstance().removeScreen(this.screen);
        MessageHandler.g(string);
        GameManager.instance.focusBuddyList();
    }
}
