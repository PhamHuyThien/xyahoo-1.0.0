package home.thienph.xyahoo;

public final class thien_r {
    public String a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public int[] f;
    public int g;
    public int h;
    public int i;
    private int k = 0xFFFFFF;
    public Integer j;

    public thien_r() {
    }

    public thien_r(String string, String string2, int n, String string3, int[] nArray, int n2, int n3) {
        this.a = string;
        this.b = string2.equals("") || string2 == null ? string : string2;
        this.c = n;
        this.d = string3;
        this.f = nArray;
        this.g = n2;
        this.h = n3;
    }

    public final int a() {
        return this.k;
    }

    public final void a(int n) {
        this.k = MessageHandler.c(n);
        this.j = new Integer(this.k);
    }
}
