package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.RegisterScreen;

public final class thien_ek
        implements IAction {
    public thien_ek(RegisterScreen registerScreen2) {
    }

    public final void action() {
        ConnectionManager.disconnect();
        GameManager.getInstance().closeTopDialog();
    }
}
