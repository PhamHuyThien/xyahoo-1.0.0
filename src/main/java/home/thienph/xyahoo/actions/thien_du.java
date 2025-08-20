package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_du
implements IAction {
    public thien_du(GameManager gameManager2) {
    }

    public final void action() {
        Xuka.instance.stopApp();
    }
}
