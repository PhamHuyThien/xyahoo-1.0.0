package home.thienph.xyahoo;

final class thien_ey
implements thien_ae {
    private thien_ew a;
    private final boolean b;

    thien_ey(thien_ew thien_ew2, boolean bl) {
        this.a = thien_ew2;
        this.b = bl;
    }

    public final void a() {
        String string;
        String string2 = string = this.a.w ? thien_gp.x : thien_ff.y;
        if (this.b) {
            MessageHandler.a(string, this.a.x, 2);
        } else {
            MessageHandler.a(string, this.a.g, 1);
        }
        this.a.z.a(this.b ? thien_gp.y : thien_ff.A, this.b ? TextConstant.buzz[0] : TextConstant.buzz(), 0);
        thien_di.b().a();
        this.a.z.b();
    }
}
