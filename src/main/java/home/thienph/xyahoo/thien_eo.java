package home.thienph.xyahoo;

final class thien_eo
implements IAction {
    private RoomListScreen a;

    thien_eo(RoomListScreen roomListScreen2) {
        this.a = roomListScreen2;
    }

    public final void action() {
        Packet packet2 = new Packet(0x4C4B4C, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
