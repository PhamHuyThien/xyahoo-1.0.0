package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class PasteAction
implements IAction {
    private ChatRoomScreen chatRoomScreen;

    public PasteAction(ChatRoomScreen chatRoomScreen2) {
        this.chatRoomScreen = chatRoomScreen2;
    }

    public final void action() {
        if (!GameManager.statusMessage.equals("")) {
            this.chatRoomScreen.inputTextField.insertText(GameManager.statusMessage);
        }
    }
}
