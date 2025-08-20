package home.thienph.xyahoo;

final class LeftButtonAction
implements IAction {
    private final byte[] data;

    LeftButtonAction(byte[] byArray) {
        this.data = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.data);
    }
}
