package home.thienph.xyahoo;

public final class thien_cl
extends thien_ap {
    public thien_at D;

    public thien_cl(String string, String string2) {
        this.p = true;
        this.g = string;
        this.D = thien_y.b(this, string2, 0, -1);
        this.k = new thien_ab(TextConstant.close(), new thien_cm(this));
        this.c(this.D);
    }

    public final void a(thien_ae thien_ae2) {
        this.m = new thien_ab("OK", thien_ae2);
    }
}
