package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.InviteConferenceScreen;

public final class CloseInviteConferenceAction
implements IAction {
    private InviteConferenceScreen inviteConferenceScreen;

    public CloseInviteConferenceAction(InviteConferenceScreen inviteConferenceScreen2) {
        this.inviteConferenceScreen = inviteConferenceScreen2;
    }

    public final void action() {
        GameManager.getInstance().showFriendsList();
        MessageHandler.h(this.inviteConferenceScreen.roomId);
    }
}
