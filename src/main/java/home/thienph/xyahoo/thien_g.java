package home.thienph.xyahoo;

final class thien_g
implements thien_ae {
    private final byte[] a;

    thien_g(byte[] byArray) {
        this.a = byArray;
    }

    public final void a() {
        MessageHandler.processRawPacket(this.a);
    }
}
