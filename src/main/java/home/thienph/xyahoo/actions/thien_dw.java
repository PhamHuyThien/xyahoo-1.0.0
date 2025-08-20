package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

public final class thien_dw implements IAction {
    private GameManager gameManager;
    private final TextField textField;
    private final Screen screen;
    private final UIDropdown uiDropdown;

    public thien_dw(GameManager gameManager2, TextField textField2, Screen screen2, UIDropdown UIDropdown2) {
        this.gameManager = gameManager2;
        this.textField = textField2;
        this.screen = screen2;
        this.uiDropdown = UIDropdown2;
    }

    public final void action() {
        String string = this.textField.getText();
        if (string.equals("")) {
            this.screen.selectControl(this.textField);
            return;
        }
        GameManager.blockedUsers.addElement(string);
        MessageHandler.i(BuddyListScreen.currentGroupName, string);
        int n = 0;
        while (n < this.uiDropdown.a.length) {
            if (string.equals(this.uiDropdown.a[n])) {
                this.gameManager.showSimpleDialog(String.valueOf(TextConstant.deleteSuccess()) + string);
                this.gameManager.removeScreen(this.screen);
                this.gameManager.goToFirstScreen();
                return;
            }
            ++n;
        }
        this.gameManager.showSimpleDialog(String.valueOf(TextConstant.add2()) + string + TextConstant.success());
        this.gameManager.removeScreen(this.screen);
        this.gameManager.goToFirstScreen();
    }
}
