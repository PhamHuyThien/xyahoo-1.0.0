package home.thienph.xyahoo;

final class thien_dv
        implements IAction {
    private final thien_z a;
    private final TextField b;

    thien_dv(thien_di thien_di2, thien_z thien_z2, TextField textField2) {
        this.a = thien_z2;
        this.b = textField2;
    }

    public final void action() {
        String string = this.a.b();
        if (!string.equals("---")) {
            this.b.setText(string);
        }
    }
}
