package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class CloseRoomListAction implements IAction {
    private RoomListScreen roomListScreen;

    public CloseRoomListAction(RoomListScreen roomListScreen2) {
        this.roomListScreen = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.roomListScreen);
    }
}
