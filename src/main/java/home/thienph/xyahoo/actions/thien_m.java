package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

public final class thien_m
implements IAction {
    public thien_m() {
    }

    public final void action() {
        GameManager.getInstance().showEmoticonPicker(0);
    }
}
