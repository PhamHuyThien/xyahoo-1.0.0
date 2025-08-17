package home.thienph.xyahoo;

public final class thien_hb {
    private int a;
    private int b;
    private thien_ha c;

    public thien_hb() {
        this.c = new thien_ha();
    }

    public thien_hb(int n, int n2) {
        this.a = n;
        this.b = n2;
        this.c = new thien_ha();
    }

    thien_hb(int n, int n2, byte[] byArray) {
        this.a = n;
        this.b = n2;
        this.c = new thien_ha(byArray);
    }

    public final int a() {
        return this.a;
    }

    public final thien_ha b() {
        return this.c;
    }

    public final void a(thien_ha thien_ha2) {
        this.c = thien_ha2;
    }

    public final int c() {
        return this.b;
    }
}
