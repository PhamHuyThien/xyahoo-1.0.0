package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.UIGridMenu;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.Screen;

public final class thien_q
implements IAction {
    private final boolean a;
    private final UIGridMenu uiGridMenu;
    private final Packet packet;

    public thien_q(boolean bl, UIGridMenu UIGridMenu2, Packet packet2) {
        this.a = bl;
        this.uiGridMenu = UIGridMenu2;
        this.packet = packet2;
    }

    public final void action() {
        int n;
        Screen screen2;
        if (this.a && (screen2 = GameManager.instance.findScreenById(n = this.uiGridMenu.getSelectedItemId())) != null) {
            screen2.startSlide(1);
            GameManager.instance.switchToScreen(screen2);
            return;
        }
        MessageHandler.processRawPacket(MessageHandler.readByteArray(this.packet));
    }
}
