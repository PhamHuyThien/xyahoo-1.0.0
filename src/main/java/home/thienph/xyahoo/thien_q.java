package home.thienph.xyahoo;

final class thien_q
implements IAction {
    private final boolean a;
    private final UIGridMenu b;
    private final Packet c;

    thien_q(boolean bl, UIGridMenu UIGridMenu2, Packet packet2) {
        this.a = bl;
        this.b = UIGridMenu2;
        this.c = packet2;
    }

    public final void action() {
        int n;
        Screen screen2;
        if (this.a && (screen2 = thien_di.instance.d(n = this.b.getSelectedItemId())) != null) {
            screen2.startSlide(1);
            thien_di.instance.d(screen2);
            return;
        }
        MessageHandler.processRawPacket(MessageHandler.readByteArray(this.c));
    }
}
