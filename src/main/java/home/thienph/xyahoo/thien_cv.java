package home.thienph.xyahoo;

final class thien_cv
implements IAction {
    private final thien_x a;
    private final thien_x b;
    private final thien_z c;
    private final thien_x d;
    private final thien_x e;

    thien_cv(thien_x thien_x2, thien_x thien_x3, thien_z thien_z2, thien_x thien_x4, thien_x thien_x5) {
        this.a = thien_x2;
        this.b = thien_x3;
        this.c = thien_z2;
        this.d = thien_x4;
        this.e = thien_x5;
    }

    public final void action() {
        GameManager.getInstance().l.startSlide(1);
        GameManager.getInstance().c(LoginScreen.getSettingsScreen());
        if (GameManager.r != this.a.a) {
            GameManager.r = this.a.a;
            Xuka.saveFlag("atlog", GameManager.r);
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
