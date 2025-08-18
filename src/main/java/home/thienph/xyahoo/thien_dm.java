package home.thienph.xyahoo;

final class thien_dm
implements thien_ae {
    final thien_di a;
    private final String b;
    private final thien_ae c;

    thien_dm(thien_di thien_di2, String string, thien_ae thien_ae2) {
        this.a = thien_di2;
        this.b = string;
        this.c = thien_ae2;
    }

    public final void a() {
        this.a.c();
        Xuka.startThread(this.b, this.a.v(), new thien_dn(this), new thien_do(this, this.c), false);
    }
}
