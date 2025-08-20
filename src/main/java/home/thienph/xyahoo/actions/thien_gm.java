package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_gm
implements IAction {
    private final TextField textField;
    private final UIDropdown uiDropdown;
    private final Screen screen;

    public thien_gm(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2, Screen screen2) {
        this.textField = textField2;
        this.uiDropdown = UIDropdown2;
        this.screen = screen2;
    }

    public final void action() {
        String string = this.textField.getText().trim();
        if (string.equals("")) {
            return;
        }
        String string2 = this.uiDropdown.getSelectedItem();
        MessageHandler.j(string2, string);
        GameManager.getInstance().removeScreen(this.screen);
        GameManager.instance.focusBuddyList();
    }
}
