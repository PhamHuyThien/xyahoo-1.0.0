package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginYahooScreen;

public final class thien_gs
implements IAction {
    public thien_gs(LoginYahooScreen loginYahooScreen2) {
    }

    public final void action() {
        GameManager.getInstance().closeTopDialog();
        Packet packet2 = new Packet(66, 12);
        ConnectionManager.sendPacket(packet2);
    }
}
