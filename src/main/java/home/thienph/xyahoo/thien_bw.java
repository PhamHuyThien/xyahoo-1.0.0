package home.thienph.xyahoo;

final class thien_bw implements IAction
{
    private BigTwoGameScreen a;
    
    thien_bw(final BigTwoGameScreen a) {
        this.a = a;
    }
    
    public final void action() {
        GameManager.instance.c(BigTwoGameScreen.instance);
        thien_ay.b = null;
        thien_ay.a = null;
        BigTwoGameScreen.a(this.a, (thien_ay)null);
        System.gc();
    }
}
