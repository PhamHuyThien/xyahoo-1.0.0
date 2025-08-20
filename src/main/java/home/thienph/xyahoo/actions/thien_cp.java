package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.InviteConferenceScreen;

public final class thien_cp
implements IAction {
    private InviteConferenceScreen inviteConferenceScreen;

    public thien_cp(InviteConferenceScreen inviteConferenceScreen2) {
        this.inviteConferenceScreen = inviteConferenceScreen2;
    }

    public final void action() {
        GameManager.getInstance().showFriendsList();
        MessageHandler.h(this.inviteConferenceScreen.w);
    }
}
