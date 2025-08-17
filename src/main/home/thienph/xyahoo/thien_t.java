package home.thienph.xyahoo;

import java.util.Vector;

public final class thien_t {
    public Vector a;
    private String b;
    private int c;

    public thien_t(String string) {
        this.b = string;
        this.a = new Vector();
    }

    public final void a(thien_r thien_r2) {
        this.a.addElement(thien_r2);
    }

    public final thien_r a(String string) {
        thien_r thien_r2 = null;
        int n = this.a.size();
        while (--n >= 0) {
            thien_r thien_r3 = (thien_r)this.a.elementAt(n);
            if (!thien_r3.a.equals(string)) continue;
            thien_r2 = thien_r3;
            break;
        }
        return thien_r2;
    }

    public final String a() {
        return this.b;
    }

    public final void b(String string) {
        this.b = string;
    }

    public final int b() {
        return this.c;
    }

    public final void a(int n) {
        this.c = n;
    }
}
