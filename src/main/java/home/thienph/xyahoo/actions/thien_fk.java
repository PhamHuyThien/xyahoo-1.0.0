package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_fk
implements IAction {
    private final TextField textField;
    private final Screen screen;
    private final String c;
    private final String d;

    public thien_fk(BuddyListScreen buddyListScreen2, TextField textField2, Screen screen2, String string, String string2) {
        this.textField = textField2;
        this.screen = screen2;
        this.c = string;
        this.d = string2;
    }

    public final void action() {
        String string = this.textField.getText().trim();
        if (string.equals("")) {
            this.screen.selectControl(this.textField);
            return;
        }
        GameManager.instance.focusBuddyList();
        if (string.equals(this.c)) {
            GameManager.getInstance().removeScreen(this.screen);
            return;
        }
        MessageHandler.g(this.d, string);
        GameManager.getInstance().removeScreen(this.screen);
    }
}
