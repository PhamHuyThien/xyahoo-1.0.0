package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class RegisterAction
implements IAction {
    private LoginScreen a;

    public RegisterAction(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.a);
        GameManager.instance.showRegisterScreen();
    }
}
