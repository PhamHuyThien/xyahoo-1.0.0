package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.FormScreen;

public final class thien_dr
implements IAction {
    private GameManager gameManager;
    private final TextField textField;
    private final String c;
    private final FormScreen formScreen;

    public thien_dr(GameManager gameManager2, TextField textField2, String string, FormScreen formScreen2) {
        this.gameManager = gameManager2;
        this.textField = textField2;
        this.c = string;
        this.formScreen = formScreen2;
    }

    public final void action() {
        MessageHandler.a(false, this.textField.getText(), this.c);
        this.gameManager.removeScreen(this.formScreen);
    }
}
