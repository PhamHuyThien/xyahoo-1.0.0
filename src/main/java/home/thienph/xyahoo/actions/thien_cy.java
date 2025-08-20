package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class thien_cy implements IAction {
    public thien_cy(LoginScreen loginScreen2) {
    }

    public final void action() {
        ConnectionManager.disconnect();
        GameManager.getInstance().closeTopDialog();
    }
}
