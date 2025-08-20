package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_dq implements IAction {
    private final UIDropdown uiDropdown;
    private final TextField textField;

    public thien_dq(GameManager gameManager2, UIDropdown UIDropdown2, TextField textField2) {
        this.uiDropdown = UIDropdown2;
        this.textField = textField2;
    }

    public final void action() {
        if (this.uiDropdown.options != null && this.uiDropdown.options.length != 0) {
            this.textField.setText(this.uiDropdown.getSelectedItem());
        }
    }
}
