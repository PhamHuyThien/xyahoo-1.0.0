package home.thienph.xyahoo;

final class thien_dv
        implements thien_ae {
    private final thien_z a;
    private final thien_at b;

    thien_dv(thien_di thien_di2, thien_z thien_z2, thien_at thien_at2) {
        this.a = thien_z2;
        this.b = thien_at2;
    }

    public final void a() {
        String string = this.a.b();
        if (!string.equals("---")) {
            this.b.a(string);
        }
    }
}
