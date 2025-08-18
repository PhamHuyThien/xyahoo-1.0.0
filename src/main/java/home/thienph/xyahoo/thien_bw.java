package home.thienph.xyahoo;

final class thien_bw implements IAction
{
    private thien_ba a;
    
    thien_bw(final thien_ba a) {
        this.a = a;
    }
    
    public final void action() {
        GameManager.instance.c(thien_ba.S);
        thien_ay.b = null;
        thien_ay.a = null;
        thien_ba.a(this.a, (thien_ay)null);
        System.gc();
    }
}
