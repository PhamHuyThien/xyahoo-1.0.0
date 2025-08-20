package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.ContactListUI;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;

public final class thien_dp implements IAction {
    public thien_dp(GameManager var1) {
    }

    public final void action() {
        ContactListUI var1 = GameManager.roomListScreen.contactListUI;
        MessageHandler.b((GameManager.roomListScreen.contactListUI.a < 0 ? null : (thien_u) var1.c.elementAt(var1.a)).d);
    }
}

