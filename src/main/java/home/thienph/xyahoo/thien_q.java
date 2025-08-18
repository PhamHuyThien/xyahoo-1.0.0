package home.thienph.xyahoo;

final class thien_q
implements thien_ae {
    private final boolean a;
    private final thien_af b;
    private final Packet c;

    thien_q(boolean bl, thien_af thien_af2, Packet packet2) {
        this.a = bl;
        this.b = thien_af2;
        this.c = packet2;
    }

    public final void a() {
        int n;
        thien_an thien_an2;
        if (this.a && (thien_an2 = thien_di.c.d(n = this.b.a())) != null) {
            thien_an2.a(1);
            thien_di.c.d(thien_an2);
            return;
        }
        MessageHandler.processRawPacket(MessageHandler.readByteArray(this.c));
    }
}
