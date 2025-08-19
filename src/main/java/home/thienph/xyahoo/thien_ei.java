package home.thienph.xyahoo;

final class thien_ei
implements IAction {
    private RegisterScreen a;

    thien_ei(RegisterScreen registerScreen2) {
        this.a = registerScreen2;
    }

    public final void action() {
        this.a.f();
    }
}
