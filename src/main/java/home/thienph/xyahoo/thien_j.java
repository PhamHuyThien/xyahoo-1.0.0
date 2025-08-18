package home.thienph.xyahoo;

final class thien_j
implements IAction {
    private final byte[] a;

    thien_j(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
