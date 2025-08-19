package home.thienph.xyahoo;

final class thien_cp
implements IAction {
    private InviteConferenceScreen a;

    thien_cp(InviteConferenceScreen inviteConferenceScreen2) {
        this.a = inviteConferenceScreen2;
    }

    public final void action() {
        GameManager.getInstance().i();
        MessageHandler.h(this.a.w);
    }
}
