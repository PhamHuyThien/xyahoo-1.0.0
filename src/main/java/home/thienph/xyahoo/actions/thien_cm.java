package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

final class thien_cm implements IAction {
    private thien_cl a;

    thien_cm(thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void action() {
        GameManager.instance.removeScreen(this.a);
    }
}
