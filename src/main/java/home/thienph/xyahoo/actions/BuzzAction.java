package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.ChatRoomScreen;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class BuzzAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;
    private final boolean isPrivateChat;

    public BuzzAction(ChatRoomScreen chatRoomScreen2, boolean bl) {
        this.chatRoomScreen = chatRoomScreen2;
        this.isPrivateChat = bl;
    }

    public final void action() {
        String string;
        String string2 = string = this.chatRoomScreen.isPrivateChat ? LoginYahooScreen.currentUsername : BuddyListScreen.currentGroupName;
        if (this.isPrivateChat) {
            MessageHandler.a(string, this.chatRoomScreen.chatPartnerName, 2);
        } else {
            MessageHandler.a(string, this.chatRoomScreen.title, 1);
        }
        this.chatRoomScreen.messageList.addUserMessage(this.isPrivateChat ? LoginYahooScreen.originalUsername : BuddyListScreen.userStatusMessage, this.isPrivateChat ? TextConstant.buzz[0] : TextConstant.buzz(), 0);
        GameManager.getInstance().vibrate();
        this.chatRoomScreen.messageList.scrollToBottom();
    }
}
