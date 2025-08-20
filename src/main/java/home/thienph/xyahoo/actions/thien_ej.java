package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.RegisterScreen;

public final class thien_ej
implements IAction {
    private RegisterScreen registerScreen;

    public thien_ej(RegisterScreen registerScreen2) {
        this.registerScreen = registerScreen2;
    }

    public final void action() {
        this.registerScreen.g();
    }
}
