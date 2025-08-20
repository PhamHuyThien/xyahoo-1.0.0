package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.screens.FormScreen;
import home.thienph.xyahoo.utils.UIFormBuilder;

public final class thien_cl extends FormScreen {
    public TextField textField;

    public thien_cl(String string, String string2) {
        this.isLocked = true;
        this.title = string;
        this.textField = UIFormBuilder.addTextFieldWithLabel(this, string2, 0, -1);
        this.leftCommand = new UIAction(TextConstant.close(), new thien_cm(this));
        this.selectControl(this.textField);
    }

    public final void a(IAction IAction2) {
        this.centerCommand = new UIAction("OK", IAction2);
    }
}
