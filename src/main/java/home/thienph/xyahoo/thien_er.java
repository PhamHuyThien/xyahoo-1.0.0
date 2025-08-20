package home.thienph.xyahoo;

final class thien_er
implements IAction {
    private RoomListScreen a;

    thien_er(RoomListScreen roomListScreen2) {
        this.a = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.a.y, 0);
    }
}
