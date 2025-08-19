package home.thienph.xyahoo;

final class thien_ez
implements IAction {
    private ChatRoomScreen a;

    thien_ez(ChatRoomScreen chatRoomScreen2) {
        this.a = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().inviteConferenceScreen.w = this.a.subtitle;
        GameManager.getInstance().h();
    }
}
