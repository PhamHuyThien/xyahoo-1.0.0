package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class chatRoomOpenMenuAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public chatRoomOpenMenuAction(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(ChatRoomScreen.getPopupMenuData(this.chatRoomScreen), 0);
    }
}
