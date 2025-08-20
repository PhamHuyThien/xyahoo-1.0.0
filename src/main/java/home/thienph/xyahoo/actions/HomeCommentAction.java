package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIAction;
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
        this.homeScreen.G = true;
        if (this.homeScreen.F == null) {
            this.homeScreen.F = new TextField("", 250, 0);
            this.homeScreen.F.isEditable = false;
            this.homeScreen.F.setBounds(0, Screen.formHeight - (TextRenderer.fontHeight << 1) + 8, Screen.e - 1, TextRenderer.fontHeight + 6);
            this.homeScreen.F.actionPrimary = new UIAction(TextConstant.exit(), new thien_cf(this));
            this.homeScreen.F.actionTertiary = new UIAction(TextConstant.send(), new thien_cg(this));
        } else {
            this.homeScreen.F.setText("");
        }
        this.homeScreen.addControl(this.homeScreen.F);
        this.homeScreen.selectControl(this.homeScreen.F);
    }
}
