package home.thienph.xyahoo;

final class thien_p
implements IAction {
    private final byte[] a;

    thien_p(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
