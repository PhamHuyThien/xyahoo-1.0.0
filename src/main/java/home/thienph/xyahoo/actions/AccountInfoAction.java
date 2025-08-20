package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.BigTwoGameScreen;
import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.data.networks.Packet;

public final class AccountInfoAction
implements IAction {
    public AccountInfoAction(BigTwoGameScreen bigTwoGameScreen2) {
    }

    public final void action() {
        Packet packet2 = new Packet(3416, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
