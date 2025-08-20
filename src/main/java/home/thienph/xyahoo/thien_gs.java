package home.thienph.xyahoo;

final class thien_gs
implements IAction {
    thien_gs(LoginYahooScreen loginYahooScreen2) {
    }

    public final void action() {
        GameManager.getInstance().closeTopDialog();
        Packet packet2 = new Packet(66, 12);
        ConnectionManager.sendPacket(packet2);
    }
}
