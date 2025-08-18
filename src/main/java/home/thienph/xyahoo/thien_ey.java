package home.thienph.xyahoo;

final class thien_ey
implements IAction {
    private thien_ew a;
    private final boolean b;

    thien_ey(thien_ew thien_ew2, boolean bl) {
        this.a = thien_ew2;
        this.b = bl;
    }

    public final void action() {
        String string;
        String string2 = string = this.a.w ? thien_gp.x : thien_ff.y;
        if (this.b) {
            MessageHandler.a(string, this.a.x, 2);
        } else {
            MessageHandler.a(string, this.a.title, 1);
        }
        this.a.z.a(this.b ? thien_gp.y : thien_ff.A, this.b ? TextConstant.buzz[0] : TextConstant.buzz(), 0);
        GameManager.getInstance().a();
        this.a.z.b();
    }
}
