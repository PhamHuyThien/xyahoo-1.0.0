package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bk
implements IAction {
    public thien_bk(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        GameManager.getInstance().closeTopDialog();
    }
}
