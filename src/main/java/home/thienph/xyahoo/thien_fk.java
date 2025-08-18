package home.thienph.xyahoo;

final class thien_fk
implements thien_ae {
    private final thien_at a;
    private final thien_an b;
    private final String c;
    private final String d;

    thien_fk(thien_ff thien_ff2, thien_at thien_at2, thien_an thien_an2, String string, String string2) {
        this.a = thien_at2;
        this.b = thien_an2;
        this.c = string;
        this.d = string2;
    }

    public final void a() {
        String string = this.a.c().trim();
        if (string.equals("")) {
            this.b.c(this.a);
            return;
        }
        thien_di.c.l();
        if (string.equals(this.c)) {
            thien_di.b().c(this.b);
            return;
        }
        MessageHandler.g(this.d, string);
        thien_di.b().c(this.b);
    }
}
