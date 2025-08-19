package home.thienph.xyahoo;

final class thien_el
implements IAction {
    private RegisterScreen registerScreen;

    thien_el(RegisterScreen registerScreen2) {
        this.registerScreen = registerScreen2;
    }

    public final void action() {
        GameCanvas.instance.connectToServer();
        RegisterScreen.a(this.registerScreen, this.registerScreen.fullNameField.getText());
        this.registerScreen.F = this.registerScreen.E.getText();
        MessageHandler.e(this.registerScreen.G, this.registerScreen.E.getText());
    }
}
