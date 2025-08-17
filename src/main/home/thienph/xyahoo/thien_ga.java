package home.thienph.xyahoo;

final class thien_ga
implements thien_ae {
    private thien_ff a;

    thien_ga(thien_ff thien_ff2) {
        this.a = thien_ff2;
    }

    public final void a() {
        boolean bl;
        thien_u thien_u2;
        block6: {
            thien_u2 = this.a.x.h();
            if (thien_u2 == null) {
                return;
            }
            if (thien_u2.a == 0) {
                if (thien_u2.g == 3) {
                    return;
                }
                this.a.x.g();
                thien_a.f(thien_u2.d);
                return;
            }
            String string = thien_u2.d;
            thien_s thien_s2 = this.a.x.b();
            int n = thien_s2.a.size() - 1;
            while (n >= 0) {
                thien_t thien_t2 = (thien_t)thien_s2.a.elementAt(n);
                if (thien_t2.a().equals(string)) {
                    bl = thien_t2.a.size() == 0;
                    break block6;
                }
                --n;
            }
            bl = false;
        }
        if (bl) {
            thien_a.e(thien_u2.d);
            thien_di.b().j.x.a(thien_u2.d);
            return;
        }
        thien_di.b().b(thien_as.ai());
    }
}
