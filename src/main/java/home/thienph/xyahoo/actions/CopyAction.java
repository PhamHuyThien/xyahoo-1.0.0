package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class CopyAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public CopyAction(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        String string = this.chatRoomScreen.messageList.getSelectedMessage();
        if (!string.equals("")) {
            GameManager.statusMessage = string;
        }
    }
}
