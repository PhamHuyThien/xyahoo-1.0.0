package home.thienph.xyahoo;

final class thien_c
implements IAction {
    private thien_b a;

    thien_c(thien_b thien_b2) {
        this.a = thien_b2;
    }

    public final void action() {
        Object object = this.a.c ? "Y! " + thien_b.a((thien_b)this.a).d : thien_b.a((thien_b)this.a).d;
        thien_ew thien_ew2 = (thien_ew) GameManager.instance.c((String)object);
        if (thien_ew2 != null) {
            thien_ew2.startSlide(1);
            GameManager.instance.d((String)object);
            return;
        }
        if (this.a.c) {
            thien_ew2 = new thien_ew((String)object, this.a.c, false, null);
            new thien_ew((String)object, this.a.c, false, null).x = thien_b.a((thien_b)this.a).d;
        } else {
            thien_ew2 = new thien_ew((String)object, this.a.c, false, thien_b.a((thien_b)this.a).j);
            new thien_ew((String)object, this.a.c, false, thien_b.a((thien_b)this.a).j).y = thien_b.a((thien_b)this.a).e.equals("") ? thien_b.a((thien_b)this.a).d : thien_b.a((thien_b)this.a).e;
            object = thien_b.a((thien_b)this.a).i;
            if (object != null) {
                thien_ew2.b(Integer.toString(((thien_r)object).i));
            }
        }
        thien_ew2.startSlide(1);
        GameManager.instance.displayScreen(thien_ew2);
        GameManager.instance.d(thien_ew2.title);
    }
}
