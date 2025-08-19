package home.thienph.xyahoo;

final class AccountInfoAction
implements IAction {
    AccountInfoAction(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        Packet packet2 = new Packet(3416, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
