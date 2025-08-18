package home.thienph.xyahoo;

final class thien_gj
implements IAction {
    private final TextField a;
    private final thien_z b;

    thien_gj(thien_ff thien_ff2, TextField textField2, thien_z thien_z2) {
        this.a = textField2;
        this.b = thien_z2;
    }

    public final void action() {
        this.a.setText(this.b.b());
    }
}
