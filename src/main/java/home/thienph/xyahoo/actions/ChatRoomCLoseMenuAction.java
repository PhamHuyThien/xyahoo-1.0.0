package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class ChatRoomCLoseMenuAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;
    private final boolean isGroupChat;

    public ChatRoomCLoseMenuAction(ChatRoomScreen chatRoomScreen2, boolean bl) {
        this.chatRoomScreen = chatRoomScreen2;
        this.isGroupChat = bl;
    }

    public final void action() {
        if (this.isGroupChat) {
            MessageHandler.h(this.chatRoomScreen.subtitle);
        }
        GameManager.getInstance().removeScreen(this.chatRoomScreen);
    }
}
