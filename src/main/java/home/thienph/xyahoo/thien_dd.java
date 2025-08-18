package home.thienph.xyahoo;

final class thien_dd
implements thien_ae {
    private thien_cq a;

    thien_dd(thien_cq thien_cq2) {
        this.a = thien_cq2;
    }

    public final void a() {
        thien_cq.a(this.a);
        if (this.a.D.c().equals("")) {
            thien_di.b().b(TextConstant.enterYourYahooId());
            return;
        }
        GameCanvas.instance.connectToServer();
        MessageHandler.b();
        Packet packet2 = new Packet(269, 13);
        thien_hc.a(packet2);
        thien_di.b().b(TextConstant.pleaseWait());
    }
}
