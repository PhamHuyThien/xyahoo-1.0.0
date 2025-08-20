package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_fj
        implements IAction {
    private final TextField textField;
    private final UIDropdown uiDropdown;

    public thien_fj(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2) {
        this.textField = textField2;
        this.uiDropdown = UIDropdown2;
    }

    public final void action() {
        this.textField.setText(this.uiDropdown.getSelectedItem());
    }
}
