package home.thienph.xyahoo;

final class thien_k
implements IAction {
    private final byte[] a;

    thien_k(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
