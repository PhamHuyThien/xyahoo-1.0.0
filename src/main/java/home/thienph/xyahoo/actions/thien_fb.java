package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_fb
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public thien_fb(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        if (!GameManager.statusMessage.equals("")) {
            this.chatRoomScreen.A.insertText(GameManager.statusMessage);
        }
    }
}
