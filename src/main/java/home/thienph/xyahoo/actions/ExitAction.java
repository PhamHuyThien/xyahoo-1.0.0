package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginScreen;
import home.thienph.xyahoo.main.Xuka;

public final class ExitAction
implements IAction {
    public ExitAction(LoginScreen loginScreen2) {
    }

    public final void action() {
        Xuka.instance.stopApp();
    }
}
