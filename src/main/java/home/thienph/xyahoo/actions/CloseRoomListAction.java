package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.GameRoomListScreen;

public final class CloseRoomListAction implements IAction {
    private GameRoomListScreen gameRoomListScreen;

    public CloseRoomListAction(GameRoomListScreen gameRoomListScreen2) {
        this.gameRoomListScreen = gameRoomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().removeScreen(this.gameRoomListScreen);
    }
}
