package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.screens.HomeScreen;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.utils.TextRenderer;

public final class HomeCommentAction
implements IAction {
    final HomeScreen homeScreen;

    public HomeCommentAction(HomeScreen homeScreen2) {
        this.homeScreen = homeScreen2;
    }

    public final void action() {
        this.homeScreen.isInputBlocked = true;
        if (this.homeScreen.searchTextField == null) {
            this.homeScreen.searchTextField = new TextField("", 250, 0);
            this.homeScreen.searchTextField.isEditable = false;
            this.homeScreen.searchTextField.setBounds(0, Screen.formHeight - (TextRenderer.fontHeight << 1) + 8, Screen.e - 1, TextRenderer.fontHeight + 6);
            this.homeScreen.searchTextField.actionPrimary = new UIAction(TextConstant.exit(), new thien_cf(this));
            this.homeScreen.searchTextField.actionTertiary = new UIAction(TextConstant.send(), new thien_cg(this));
        } else {
            this.homeScreen.searchTextField.setText("");
        }
        this.homeScreen.addControl(this.homeScreen.searchTextField);
        this.homeScreen.selectControl(this.homeScreen.searchTextField);
    }
}
