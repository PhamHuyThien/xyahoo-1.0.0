package home.thienph.xyahoo;

final class thien_ej
implements IAction {
    private RegisterScreen a;

    thien_ej(RegisterScreen registerScreen2) {
        this.a = registerScreen2;
    }

    public final void action() {
        this.a.g();
    }
}
