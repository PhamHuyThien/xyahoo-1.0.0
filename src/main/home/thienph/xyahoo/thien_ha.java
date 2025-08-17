package home.thienph.xyahoo;

public final class thien_ha {
    private byte[] a;
    private int b;
    private int c;

    public thien_ha() {
        this.a = new byte[32];
        this.c = 0;
    }

    public thien_ha(byte[] byArray) {
        this.a = byArray;
        this.c = 0;
        this.b = byArray.length;
    }

    public final void a(byte by) {
        this.a[this.c++] = by;
        this.d();
    }

    private void d() {
        if (this.c > this.b) {
            this.b = this.c;
        }
    }

    public final void a(int n) {
        if ((n = this.c + n) > this.a.length) {
            byte[] byArray = new byte[n];
            System.arraycopy(this.a, 0, byArray, 0, this.b);
            this.a = byArray;
        }
    }

    public final void a(byte[] byArray, int n, int n2) {
        System.arraycopy(byArray, n, this.a, this.c, n2);
        this.c += n2;
        this.d();
    }

    public final byte a() {
        return this.a[this.c++];
    }

    public final byte[] b(int n) {
        byte[] byArray = new byte[n];
        System.arraycopy(this.a, this.c, byArray, 0, n);
        this.c += n;
        return byArray;
    }

    public final byte[] b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }
}
