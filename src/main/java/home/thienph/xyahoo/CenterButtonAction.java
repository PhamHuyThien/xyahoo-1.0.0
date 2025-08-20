package home.thienph.xyahoo;

final class CenterButtonAction
implements IAction {
    private final byte[] data;

    CenterButtonAction(byte[] byArray) {
        this.data = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.data);
    }
}
