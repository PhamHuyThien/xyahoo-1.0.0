package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class OpenMenuRoomListAction implements IAction {
    private RoomListScreen roomListScreen;

    public OpenMenuRoomListAction(RoomListScreen roomListScreen2) {
        this.roomListScreen = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.roomListScreen.popupMenuData, 0);
    }
}
