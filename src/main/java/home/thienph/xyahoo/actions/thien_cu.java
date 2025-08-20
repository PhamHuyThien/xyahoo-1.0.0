package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.UICheckBox;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class thien_cu
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

    public thien_cu(UICheckBox UICheckBox2, boolean bl, UICheckBox UICheckBox3, boolean bl2, UICheckBox UICheckBox4, boolean bl3, UICheckBox UICheckBox5, boolean bl4, UIDropdown UIDropdown2, int n) {
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
        GameManager.instance.removeScreen(LoginScreen.getSettingsScreen());
        this.a.isChecked = this.b;
        this.c.isChecked = this.d;
        this.e.isChecked = this.f;
        this.g.isChecked = this.h;
        this.i.setSelectedIndex(this.j);
    }
}
