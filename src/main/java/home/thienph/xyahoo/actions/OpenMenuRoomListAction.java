package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.GameRoomListScreen;

public final class OpenMenuRoomListAction implements IAction {
    private GameRoomListScreen gameRoomListScreen;

    public OpenMenuRoomListAction(GameRoomListScreen gameRoomListScreen2) {
        this.gameRoomListScreen = gameRoomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.gameRoomListScreen.popupMenuData, 0);
    }
}
