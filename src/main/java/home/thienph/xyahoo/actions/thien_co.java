package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.InviteConferenceScreen;

public final class thien_co
        implements IAction {
    private InviteConferenceScreen inviteConferenceScreen;

    public thien_co(InviteConferenceScreen inviteConferenceScreen2) {
        this.inviteConferenceScreen = inviteConferenceScreen2;
    }

    public final void action() {
        String[] stringArray = this.inviteConferenceScreen.getSelectedBuddyIds();
        MessageHandler.a(this.inviteConferenceScreen.w, stringArray);
        GameManager.getInstance().showFriendsList();
        GameManager.getInstance().a(this.inviteConferenceScreen.w, stringArray, this.inviteConferenceScreen.x);
    }
}
