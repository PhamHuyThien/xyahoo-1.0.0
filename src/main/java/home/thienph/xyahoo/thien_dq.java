package home.thienph.xyahoo;

final class thien_dq
implements IAction {
    private final thien_z a;
    private final TextField b;

    thien_dq(thien_di thien_di2, thien_z thien_z2, TextField textField2) {
        this.a = thien_z2;
        this.b = textField2;
    }

    public final void action() {
        if (this.a.a != null && this.a.a.length != 0) {
            this.b.setText(this.a.b());
        }
    }
}
