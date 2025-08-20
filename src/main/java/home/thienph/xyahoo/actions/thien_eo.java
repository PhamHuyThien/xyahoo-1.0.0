package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.screens.RoomListScreen;

public final class thien_eo
implements IAction {
    private RoomListScreen roomListScreen;

    public thien_eo(RoomListScreen roomListScreen2) {
        this.roomListScreen = roomListScreen2;
    }

    public final void action() {
        Packet packet2 = new Packet(0x4C4B4C, 39);
        ConnectionManager.sendPacket(packet2);
    }
}
