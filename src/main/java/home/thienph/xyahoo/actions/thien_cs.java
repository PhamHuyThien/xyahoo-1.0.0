package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.LoginScreen;

public final class thien_cs
        implements IAction {
    private LoginScreen loginScreen;
    private final TextField textField;

    public thien_cs(LoginScreen loginScreen2, TextField textField2) {
        this.loginScreen = loginScreen2;
        this.textField = textField2;
    }

    public final void action() {
        this.loginScreen.removeControl(this.textField);
        this.loginScreen.selectControl(this.loginScreen.usernameField);
        MessageHandler.c(this.textField.getText());
        this.textField.setText("");
    }
}
