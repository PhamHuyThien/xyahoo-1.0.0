package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

final class thien_bi
implements IAction {
    final thien_bh a;

    thien_bi(thien_bh thien_bh2) {
        this.a = thien_bh2;
    }

    public final void action() {
        GameManager.getInstance().closeTopDialog();
        GameManager.instance.showConfirmDialog("Bạn có muốn rời bàn?", new thien_bj(this));
    }
}
