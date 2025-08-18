package home.thienph.xyahoo;

final class thien_h
implements IAction {
    private final byte[] a;

    thien_h(byte[] byArray) {
        this.a = byArray;
    }

    public final void action() {
        MessageHandler.processRawPacket(this.a);
    }
}
