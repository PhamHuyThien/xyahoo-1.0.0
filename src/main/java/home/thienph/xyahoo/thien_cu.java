package home.thienph.xyahoo;

final class thien_cu
implements IAction {
    private final thien_x a;
    private final boolean b;
    private final thien_x c;
    private final boolean d;
    private final thien_x e;
    private final boolean f;
    private final thien_x g;
    private final boolean h;
    private final thien_z i;
    private final int j;

    thien_cu(thien_x thien_x2, boolean bl, thien_x thien_x3, boolean bl2, thien_x thien_x4, boolean bl3, thien_x thien_x5, boolean bl4, thien_z thien_z2, int n) {
        this.a = thien_x2;
        this.b = bl;
        this.c = thien_x3;
        this.d = bl2;
        this.e = thien_x4;
        this.f = bl3;
        this.g = thien_x5;
        this.h = bl4;
        this.i = thien_z2;
        this.j = n;
    }

    public final void action() {
        GameManager.instance.c(LoginScreen.getSettingsScreen());
        this.a.a = this.b;
        this.c.a = this.d;
        this.e.a = this.f;
        this.g.a = this.h;
        this.i.c(this.j);
    }
}
