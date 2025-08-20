package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_dv implements IAction {
    private final UIDropdown uiDropdown;
    private final TextField textField;

    public thien_dv(GameManager gameManager2, UIDropdown UIDropdown2, TextField textField2) {
        this.uiDropdown = UIDropdown2;
        this.textField = textField2;
    }

    public final void action() {
        String string = this.uiDropdown.b();
        if (!string.equals("---")) {
            this.textField.setText(string);
        }
    }
}
