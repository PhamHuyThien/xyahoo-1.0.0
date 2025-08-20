package home.thienph.xyahoo;

final class RightButtonAction
implements IAction {
    private final byte[] data;

    RightButtonAction(byte[] byArray) {
        this.data = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.data);
    }
}
