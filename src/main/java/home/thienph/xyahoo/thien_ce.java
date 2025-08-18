package home.thienph.xyahoo;

final class thien_ce
implements thien_ae {
    final thien_ca a;

    thien_ce(thien_ca thien_ca2) {
        this.a = thien_ca2;
    }

    public final void a() {
        this.a.G = true;
        if (this.a.F == null) {
            this.a.F = new thien_at("", 250, 0);
            this.a.F.b = false;
            this.a.F.a(0, thien_an.f - (thien_w.f << 1) + 8, thien_an.e - 1, thien_w.f + 6);
            this.a.F.w = new thien_ab(thien_as.K(), new thien_cf(this));
            this.a.F.y = new thien_ab(thien_as.t(), new thien_cg(this));
        } else {
            this.a.F.a("");
        }
        this.a.a(this.a.F);
        this.a.c(this.a.F);
    }
}
