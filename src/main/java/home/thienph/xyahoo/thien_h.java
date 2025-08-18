package home.thienph.xyahoo;

final class thien_h
implements thien_ae {
    private final byte[] a;

    thien_h(byte[] byArray) {
        this.a = byArray;
    }

    public final void a() {
        MessageHandler.processRawPacket(this.a);
    }
}
