package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;

import javax.microedition.lcdui.Image;

public final class thien_fp
implements IAction {
    private BuddyListScreen buddyListScreen;
    private final TextField textField;
    private final TextField textField2;
    private final TextField textField3;
    private final Screen screen;

    public thien_fp(BuddyListScreen buddyListScreen2, TextField textField2, TextField textField3, TextField textField4, Screen screen2) {
        this.buddyListScreen = buddyListScreen2;
        this.textField = textField2;
        this.textField2 = textField3;
        this.textField3 = textField4;
        this.screen = screen2;
    }

    public final void action() {
        if (this.textField.getText().equals("")) {
            return;
        }
        if (this.textField2.getText().length() < 6 || this.textField2.getText().length() > 64) {
            GameManager.getInstance().showNotification(String.valueOf(TextConstant.password()) + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.buddyListScreen.selectControl(this.textField2);
            return;
        }
        if (this.textField2.getText().equals("") || this.textField3.getText().equals("") || !this.textField2.getText().equals(this.textField3.getText())) {
            GameManager.getInstance().showNotification(TextConstant.typePasswordAgain(), (Image)null, 1);
            this.buddyListScreen.selectControl(this.textField2);
            return;
        }
        MessageHandler.b("", this.textField.getText(), this.textField2.getText());
        GameManager.getInstance().removeScreen(this.screen);
        GameManager.instance.focusBuddyList();
    }
}
