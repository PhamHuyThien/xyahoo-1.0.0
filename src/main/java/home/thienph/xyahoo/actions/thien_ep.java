package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class thien_ep
implements IAction {
    public thien_ep(RoomListScreen roomListScreen2) {
    }

    public final void action() {
        MessageHandler.a();
    }
}
