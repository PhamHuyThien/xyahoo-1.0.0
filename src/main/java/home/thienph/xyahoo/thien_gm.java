package home.thienph.xyahoo;

final class thien_gm
implements thien_ae {
    private final thien_at a;
    private final thien_z b;
    private final thien_an c;

    thien_gm(thien_ff thien_ff2, thien_at thien_at2, thien_z thien_z2, thien_an thien_an2) {
        this.a = thien_at2;
        this.b = thien_z2;
        this.c = thien_an2;
    }

    public final void a() {
        String string = this.a.c().trim();
        if (string.equals("")) {
            return;
        }
        String string2 = this.b.b();
        MessageHandler.j(string2, string);
        thien_di.b().c(this.c);
        thien_di.c.l();
    }
}
