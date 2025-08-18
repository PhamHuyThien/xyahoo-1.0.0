package home.thienph.xyahoo;

final class thien_eo
implements IAction {
    private thien_em a;

    thien_eo(thien_em thien_em2) {
        this.a = thien_em2;
    }

    public final void action() {
        Packet packet2 = new Packet(0x4C4B4C, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
