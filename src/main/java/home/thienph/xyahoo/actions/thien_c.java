package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.UIBuddyListControl;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_c
implements IAction {
    private UIBuddyListControl uiBuddyListControl;

    public thien_c(UIBuddyListControl UIBuddyListControl2) {
        this.uiBuddyListControl = UIBuddyListControl2;
    }

    public final void action() {
        Object object = this.uiBuddyListControl.isAutoChatEnabled ? "Y! " + UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).d : UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).d;
        ChatRoomScreen chatRoomScreen2 = (ChatRoomScreen) GameManager.instance.findScreenByTitle((String)object);
        if (chatRoomScreen2 != null) {
            chatRoomScreen2.startSlide(1);
            GameManager.instance.switchToScreenByTitle((String)object);
            return;
        }
        if (this.uiBuddyListControl.isAutoChatEnabled) {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.uiBuddyListControl.isAutoChatEnabled, false, null);
            new ChatRoomScreen((String)object, this.uiBuddyListControl.isAutoChatEnabled, false, null).x = UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).d;
        } else {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.uiBuddyListControl.isAutoChatEnabled, false, UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).j);
            new ChatRoomScreen((String)object, this.uiBuddyListControl.isAutoChatEnabled, false, UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).j).y = UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).e.equals("") ? UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).d : UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).e;
            object = UIBuddyListControl.a((UIBuddyListControl)this.uiBuddyListControl).i;
            if (object != null) {
                chatRoomScreen2.b(Integer.toString(((thien_r)object).i));
            }
        }
        chatRoomScreen2.startSlide(1);
        GameManager.instance.showScreen(chatRoomScreen2);
        GameManager.instance.switchToScreenByTitle(chatRoomScreen2.title);
    }
}
