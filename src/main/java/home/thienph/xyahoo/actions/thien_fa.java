package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_fa
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public thien_fa(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        String string = this.chatRoomScreen.z.getSelectedMessage();
        if (!string.equals("")) {
            GameManager.statusMessage = string;
        }
    }
}
