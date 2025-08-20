package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.RegisterScreen;

public final class thien_ei
implements IAction {
    private RegisterScreen registerScreen;

    public thien_ei(RegisterScreen registerScreen2) {
        this.registerScreen = registerScreen2;
    }

    public final void action() {
        this.registerScreen.f();
    }
}
