package home.thienph.xyahoo;

final class thien_gs
implements IAction {
    thien_gs(thien_gp thien_gp2) {
    }

    public final void action() {
        thien_di.getInstance().c();
        Packet packet2 = new Packet(66, 12);
        ConnectionManager.sendPacket(packet2);
    }
}
