package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_fd
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public thien_fd(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(ChatRoomScreen.a(this.chatRoomScreen), 0);
    }
}
