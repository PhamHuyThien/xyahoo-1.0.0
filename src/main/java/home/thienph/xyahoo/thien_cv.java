package home.thienph.xyahoo;

final class thien_cv
implements IAction {
    private final UICheckBox a;
    private final UICheckBox b;
    private final UIDropdown c;
    private final UICheckBox d;
    private final UICheckBox e;

    thien_cv(UICheckBox UICheckBox2, UICheckBox UICheckBox3, UIDropdown UIDropdown2, UICheckBox UICheckBox4, UICheckBox UICheckBox5) {
        this.a = UICheckBox2;
        this.b = UICheckBox3;
        this.c = UIDropdown2;
        this.d = UICheckBox4;
        this.e = UICheckBox5;
    }

    public final void action() {
        GameManager.getInstance().loginScreen.startSlide(1);
        GameManager.getInstance().c(LoginScreen.getSettingsScreen());
        if (GameManager.autoLogin != this.a.a) {
            GameManager.autoLogin = this.a.a;
            Xuka.saveFlag("atlog", GameManager.autoLogin);
        }
        if (GameManager.s != this.b.a) {
            GameManager.s = this.b.a;
            Xuka.saveFlag("atlogY", GameManager.s);
        }
        if (TextField.multiTapSpeedIndex != this.c.a()) {
            TextField.multiTapSpeedIndex = this.c.a();
            Xuka.saveCaret(TextField.multiTapSpeedIndex);
        }
        if (GameManager.q != this.d.a) {
            GameManager.q = this.d.a;
            Xuka.saveFlag("vibrate", GameManager.q);
        }
        if (GameManager.p != !this.e.a) {
            GameManager.p = !this.e.a;
            Xuka.saveFlag("sound", GameManager.p);
        }
    }
}
