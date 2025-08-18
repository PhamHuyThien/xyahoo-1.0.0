package home.thienph.xyahoo;

final class thien_dw
implements thien_ae {
    private thien_di a;
    private final thien_at b;
    private final thien_an c;
    private final thien_z d;

    thien_dw(thien_di thien_di2, thien_at thien_at2, thien_an thien_an2, thien_z thien_z2) {
        this.a = thien_di2;
        this.b = thien_at2;
        this.c = thien_an2;
        this.d = thien_z2;
    }

    public final void a() {
        String string = this.b.c();
        if (string.equals("")) {
            this.c.c(this.b);
            return;
        }
        thien_di.t.addElement(string);
        MessageHandler.i(thien_ff.y, string);
        int n = 0;
        while (n < this.d.a.length) {
            if (string.equals(this.d.a[n])) {
                this.a.b(String.valueOf(thien_as.an()) + string);
                this.a.c(this.c);
                this.a.k();
                return;
            }
            ++n;
        }
        this.a.b(String.valueOf(thien_as.X()) + string + thien_as.Y());
        this.a.c(this.c);
        this.a.k();
    }
}
