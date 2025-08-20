package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.RegisterScreen;

public final class thien_el
implements IAction {
    private RegisterScreen registerScreen;

    public thien_el(RegisterScreen registerScreen2) {
        this.registerScreen = registerScreen2;
    }

    public final void action() {
        GameCanvas.instance.connectToServer();
        RegisterScreen.a(this.registerScreen, this.registerScreen.fullNameField.getText());
        this.registerScreen.F = this.registerScreen.E.getText();
        MessageHandler.e(this.registerScreen.G, this.registerScreen.E.getText());
    }
}
