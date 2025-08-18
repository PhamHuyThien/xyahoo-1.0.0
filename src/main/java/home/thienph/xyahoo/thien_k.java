package home.thienph.xyahoo;

final class thien_k
implements thien_ae {
    private final byte[] a;

    thien_k(byte[] byArray) {
        this.a = byArray;
    }

    public final void a() {
        MessageHandler.processRawPacket(this.a);
    }
}
