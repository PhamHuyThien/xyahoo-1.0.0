package home.thienph.xyahoo;

final class thien_fq
implements thien_ae {
    private thien_ff a;
    private final thien_cl b;

    thien_fq(thien_ff thien_ff2, thien_cl thien_cl2) {
        this.a = thien_ff2;
        this.b = thien_cl2;
    }

    public final void a() {
        GameCanvas.resetKeys();
        String string = this.b.D.c().trim();
        if (string.equals("")) {
            return;
        }
        thien_di.b().c(this.b);
        this.a.a(string, 0);
    }
}
