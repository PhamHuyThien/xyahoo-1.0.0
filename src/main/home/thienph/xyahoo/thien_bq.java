package home.thienph.xyahoo;

final class thien_bq
implements thien_ae {
    private thien_ba a;

    thien_bq(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void a() {
        if (!thien_ba.h().c().equals("")) {
            long l;
            this.a.b(thien_ba.h());
            thien_ba.H = false;
            this.a.c(thien_ba.g(this.a));
            try {
                l = Long.parseLong(thien_ba.h().c());
            }
            catch (Exception exception) {
                return;
            }
            if (thien_ba.ah == 1) {
                thien_a.a(thien_ba.ah, thien_ba.B, this.a.w, l);
            } else if (thien_ba.ah == 3) {
                thien_a.a(thien_ba.ah, thien_ba.B, l);
            }
        }
        thien_ba.a(this.a);
        thien_ba.h().a("");
    }
}
