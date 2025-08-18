package home.thienph.xyahoo;

final class thien_o
implements IAction {
    private final byte[] a;

    thien_o(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
