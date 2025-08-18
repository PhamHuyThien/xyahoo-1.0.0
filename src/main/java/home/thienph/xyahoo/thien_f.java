package home.thienph.xyahoo;

final class thien_f
implements thien_ae {
    private final byte[] a;

    thien_f(byte[] byArray) {
        this.a = byArray;
    }

    public final void a() {
        MessageHandler.processRawPacket(this.a);
    }
}
