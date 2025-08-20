package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_ex
implements IAction {
    public thien_ex(ChatRoomScreen chatRoomScreen2) {
    }

    public final void action() {
        GameManager.getInstance().showEmoticonPicker(0);
    }
}
