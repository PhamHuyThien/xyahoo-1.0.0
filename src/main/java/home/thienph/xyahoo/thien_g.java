package home.thienph.xyahoo;

final class thien_g
implements IAction {
    private final byte[] a;

    thien_g(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
