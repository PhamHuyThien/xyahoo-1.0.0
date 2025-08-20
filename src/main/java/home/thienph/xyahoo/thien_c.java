package home.thienph.xyahoo;

final class thien_c
implements IAction {
    private UIBuddyListControl a;

    thien_c(UIBuddyListControl UIBuddyListControl2) {
        this.a = UIBuddyListControl2;
    }

    public final void action() {
        Object object = this.a.isAutoChatEnabled ? "Y! " + UIBuddyListControl.a((UIBuddyListControl)this.a).d : UIBuddyListControl.a((UIBuddyListControl)this.a).d;
        ChatRoomScreen chatRoomScreen2 = (ChatRoomScreen) GameManager.instance.findScreenByTitle((String)object);
        if (chatRoomScreen2 != null) {
            chatRoomScreen2.startSlide(1);
            GameManager.instance.switchToScreenByTitle((String)object);
            return;
        }
        if (this.a.isAutoChatEnabled) {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.a.isAutoChatEnabled, false, null);
            new ChatRoomScreen((String)object, this.a.isAutoChatEnabled, false, null).x = UIBuddyListControl.a((UIBuddyListControl)this.a).d;
        } else {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.a.isAutoChatEnabled, false, UIBuddyListControl.a((UIBuddyListControl)this.a).j);
            new ChatRoomScreen((String)object, this.a.isAutoChatEnabled, false, UIBuddyListControl.a((UIBuddyListControl)this.a).j).y = UIBuddyListControl.a((UIBuddyListControl)this.a).e.equals("") ? UIBuddyListControl.a((UIBuddyListControl)this.a).d : UIBuddyListControl.a((UIBuddyListControl)this.a).e;
            object = UIBuddyListControl.a((UIBuddyListControl)this.a).i;
            if (object != null) {
                chatRoomScreen2.b(Integer.toString(((thien_r)object).i));
            }
        }
        chatRoomScreen2.startSlide(1);
        GameManager.instance.showScreen(chatRoomScreen2);
        GameManager.instance.switchToScreenByTitle(chatRoomScreen2.title);
    }
}
