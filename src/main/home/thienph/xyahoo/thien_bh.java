package home.thienph.xyahoo;

import java.util.Vector;

final class thien_bh implements thien_ae
{
    final thien_ba a;
    
    thien_bh(final thien_ba a) {
        this.a = a;
    }
    
    public final void a() {
        if (thien_ba.d(this.a) == null) {
            final Vector vector = new Vector();
            thien_ba.a(this.a, new thien_am(vector));
            vector.addElement(thien_ba.e(this.a));
            vector.addElement(thien_ba.f(this.a));
            vector.addElement(new thien_ab("R\u1eddi b\u00e0n", new thien_bi(this)));
        }
        thien_di.b().a(thien_ba.d(this.a), 0);
    }
}
