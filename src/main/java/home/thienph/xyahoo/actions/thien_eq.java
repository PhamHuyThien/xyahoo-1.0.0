package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class thien_eq
implements IAction {
    private RoomListScreen a;

    public thien_eq(RoomListScreen roomListScreen2) {
        this.a = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.a);
    }
}
