package home.thienph.xyahoo;

final class thien_eq
implements IAction {
    private RoomListScreen a;

    thien_eq(RoomListScreen roomListScreen2) {
        this.a = roomListScreen2;
    }

    public final void action() {
        GameManager.getInstance().c(this.a);
    }
}
