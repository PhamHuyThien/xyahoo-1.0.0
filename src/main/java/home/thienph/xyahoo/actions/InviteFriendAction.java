package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class InviteFriendAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public InviteFriendAction(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().inviteConferenceScreen.roomId = this.chatRoomScreen.subtitle;
        GameManager.getInstance().showChatRoomList();
    }
}
