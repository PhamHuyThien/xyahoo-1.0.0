package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class UpdateRoomListAction
implements IAction {
    public UpdateRoomListAction(RoomListScreen roomListScreen2) {
    }

    public final void action() {
        MessageHandler.updateRoomList();
    }
}
