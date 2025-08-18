package home.thienph.xyahoo;

final class thien_i
implements IAction {
    private final byte[] a;

    thien_i(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
