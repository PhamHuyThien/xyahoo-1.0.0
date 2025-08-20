package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_gn
        implements IAction {
    private final TextField textField;

    public thien_gn(BuddyListScreen buddyListScreen2, TextField textField2) {
        this.textField = textField2;
    }

    public final void action() {
        if (!GameManager.statusMessage.equals("")) {
            this.textField.setText(GameManager.statusMessage);
        }
    }
}
