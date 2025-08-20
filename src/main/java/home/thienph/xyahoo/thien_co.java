package home.thienph.xyahoo;

final class thien_co
implements IAction {
    private InviteConferenceScreen a;

    thien_co(InviteConferenceScreen inviteConferenceScreen2) {
        this.a = inviteConferenceScreen2;
    }

    public final void action() {
        String[] stringArray = this.a.getSelectedBuddyIds();
        MessageHandler.a(this.a.w, stringArray);
        GameManager.getInstance().showFriendsList();
        GameManager.getInstance().a(this.a.w, stringArray, this.a.x);
    }
}
