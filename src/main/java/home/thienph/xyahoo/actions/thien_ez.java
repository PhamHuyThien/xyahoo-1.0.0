package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_ez
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public thien_ez(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().inviteConferenceScreen.w = this.chatRoomScreen.subtitle;
        GameManager.getInstance().showChatRoomList();
    }
}
