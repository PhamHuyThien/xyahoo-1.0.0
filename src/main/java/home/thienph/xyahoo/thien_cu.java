package home.thienph.xyahoo;

final class thien_cu
implements IAction {
    private final UICheckBox a;
    private final boolean b;
    private final UICheckBox c;
    private final boolean d;
    private final UICheckBox e;
    private final boolean f;
    private final UICheckBox g;
    private final boolean h;
    private final UIDropdown i;
    private final int j;

    thien_cu(UICheckBox UICheckBox2, boolean bl, UICheckBox UICheckBox3, boolean bl2, UICheckBox UICheckBox4, boolean bl3, UICheckBox UICheckBox5, boolean bl4, UIDropdown UIDropdown2, int n) {
        this.a = UICheckBox2;
        this.b = bl;
        this.c = UICheckBox3;
        this.d = bl2;
        this.e = UICheckBox4;
        this.f = bl3;
        this.g = UICheckBox5;
        this.h = bl4;
        this.i = UIDropdown2;
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
