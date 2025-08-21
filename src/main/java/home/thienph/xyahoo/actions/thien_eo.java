package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.screens.GameRoomListScreen;

public final class thien_eo
implements IAction {
    private GameRoomListScreen gameRoomListScreen;

    public thien_eo(GameRoomListScreen gameRoomListScreen2) {
        this.gameRoomListScreen = gameRoomListScreen2;
    }

    public final void action() {
        Packet packet2 = new Packet(0x4C4B4C, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
