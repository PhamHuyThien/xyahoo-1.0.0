package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;

public final class thien_g
implements IAction {
    private final byte[] a;

    public thien_g(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
