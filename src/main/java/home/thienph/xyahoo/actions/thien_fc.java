package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_fc
implements IAction {
    private ChatRoomScreen chatRoomScreen;
    private final boolean b;

    public thien_fc(ChatRoomScreen chatRoomScreen2, boolean bl) {
        this.chatRoomScreen = chatRoomScreen2;
        this.b = bl;
    }

    public final void action() {
        if (this.b) {
            MessageHandler.h(this.chatRoomScreen.subtitle);
        }
        GameManager.getInstance().removeScreen(this.chatRoomScreen);
    }
}
