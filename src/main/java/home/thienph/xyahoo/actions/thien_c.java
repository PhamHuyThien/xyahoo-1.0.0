package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.BuddyListControl;
import home.thienph.xyahoo.data.data.ContactEntry;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.ChatRoomScreen;

public final class thien_c
implements IAction {
    private BuddyListControl buddyListControl;

    public thien_c(BuddyListControl BuddyListControl2) {
        this.buddyListControl = BuddyListControl2;
    }

    public final void action() {
        Object object = this.buddyListControl.isAutoChatEnabled ? "Y! " + BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).displayName : BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).displayName;
        ChatRoomScreen chatRoomScreen2 = (ChatRoomScreen) GameManager.instance.findScreenByTitle((String)object);
        if (chatRoomScreen2 != null) {
            chatRoomScreen2.startSlide(1);
            GameManager.instance.switchToScreenByTitle((String)object);
            return;
        }
        if (this.buddyListControl.isAutoChatEnabled) {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.buddyListControl.isAutoChatEnabled, false, null);
            new ChatRoomScreen((String)object, this.buddyListControl.isAutoChatEnabled, false, null).chatPartnerName = BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).displayName;
        } else {
            chatRoomScreen2 = new ChatRoomScreen((String)object, this.buddyListControl.isAutoChatEnabled, false, BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).additionalData);
            new ChatRoomScreen((String)object, this.buddyListControl.isAutoChatEnabled, false, BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).additionalData).chatPartnerStatus = BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).statusText.equals("") ? BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).displayName : BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).statusText;
            object = BuddyListControl.getSelectedDisplayItem((BuddyListControl)this.buddyListControl).sourceEntry;
            if (object != null) {
                chatRoomScreen2.setCurrentRoomName(Integer.toString(((ContactEntry)object).additionalFlags));
            }
        }
        chatRoomScreen2.startSlide(1);
        GameManager.instance.showScreen(chatRoomScreen2);
        GameManager.instance.switchToScreenByTitle(chatRoomScreen2.title);
    }
}
