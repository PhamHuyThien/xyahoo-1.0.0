package home.thienph.xyahoo;

final class thien_bs
implements IAction {
    thien_bs(thien_ba thien_ba2) {
    }

    public final void action() {
        Packet packet2 = new Packet(3416, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
