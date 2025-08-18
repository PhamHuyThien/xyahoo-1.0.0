package home.thienph.xyahoo;

import java.util.Vector;

public final class thien_s {
    public Vector a = new Vector();

    public final void a(String string, thien_r thien_r2) {
        int n = this.a.size() - 1;
        while (n >= 0) {
            if (((thien_t)this.a.elementAt(n)).a().equals(string)) {
                ((thien_t)this.a.elementAt(n)).a(thien_r2);
                return;
            }
            --n;
        }
        thien_t thien_t2 = new thien_t(string);
        thien_t2.a(thien_r2);
        this.a.addElement(thien_t2);
    }

    public final void a(String string, int n) {
        int n2 = this.a.size() - 1;
        while (n2 >= 0) {
            thien_t thien_t2 = (thien_t)this.a.elementAt(n2);
            if (thien_t2.a().equals(string)) {
                thien_t2.a(n);
                return;
            }
            --n2;
        }
    }
}
