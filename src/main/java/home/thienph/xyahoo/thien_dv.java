package home.thienph.xyahoo;

final class thien_dv
        implements IAction {
    private final UIDropdown a;
    private final TextField b;

    thien_dv(GameManager gameManager2, UIDropdown UIDropdown2, TextField textField2) {
        this.a = UIDropdown2;
        this.b = textField2;
    }

    public final void action() {
        String string = this.a.b();
        if (!string.equals("---")) {
            this.b.setText(string);
        }
    }
}
