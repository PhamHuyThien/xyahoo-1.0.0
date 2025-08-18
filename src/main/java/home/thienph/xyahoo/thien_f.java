package home.thienph.xyahoo;

final class thien_f
implements IAction {
    private final byte[] a;

    thien_f(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
