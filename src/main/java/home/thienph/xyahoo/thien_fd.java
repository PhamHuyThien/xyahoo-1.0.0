package home.thienph.xyahoo;

final class thien_fd
implements IAction {
    private ChatRoomScreen a;

    thien_fd(ChatRoomScreen chatRoomScreen2) {
        this.a = chatRoomScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(ChatRoomScreen.a(this.a), 0);
    }
}
