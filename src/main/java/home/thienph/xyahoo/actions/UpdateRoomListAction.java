package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.GameRoomListScreen;

public final class UpdateRoomListAction
implements IAction {
    public UpdateRoomListAction(GameRoomListScreen gameRoomListScreen2) {
    }

    public final void action() {
        MessageHandler.updateRoomList();
    }
}
