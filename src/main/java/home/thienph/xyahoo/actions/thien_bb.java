package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BigTwoGameScreen;

public final class thien_bb implements IAction {
    public thien_bb(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        GameManager.getInstance().showEmoticonPicker(0);
    }
}
