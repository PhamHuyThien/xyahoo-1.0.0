package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class thien_er
implements IAction {
    private RoomListScreen roomListScreen;

    public thien_er(RoomListScreen roomListScreen2) {
        this.roomListScreen = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.roomListScreen.y, 0);
    }
}
