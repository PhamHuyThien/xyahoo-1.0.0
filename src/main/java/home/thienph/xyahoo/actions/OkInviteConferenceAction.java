package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.InviteConferenceScreen;

public final class OkInviteConferenceAction
        implements IAction {
    private InviteConferenceScreen inviteConferenceScreen;

    public OkInviteConferenceAction(InviteConferenceScreen inviteConferenceScreen2) {
        this.inviteConferenceScreen = inviteConferenceScreen2;
    }

    public final void action() {
        String[] stringArray = this.inviteConferenceScreen.getSelectedBuddyIds();
        MessageHandler.a(this.inviteConferenceScreen.roomId, stringArray);
        GameManager.getInstance().showFriendsList();
        GameManager.getInstance().createOrJoinConference(this.inviteConferenceScreen.roomId, stringArray, this.inviteConferenceScreen.roomName);
    }
}
