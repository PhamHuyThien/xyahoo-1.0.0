package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.MessageHandler;

public final class RightButtonAction
implements IAction {
    private final byte[] data;

    public RightButtonAction(byte[] byArray) {
        this.data = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.data);
    }
}
