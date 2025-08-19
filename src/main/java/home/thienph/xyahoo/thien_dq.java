package home.thienph.xyahoo;

final class thien_dq
implements IAction {
    private final UIDropdown a;
    private final TextField b;

    thien_dq(GameManager gameManager2, UIDropdown UIDropdown2, TextField textField2) {
        this.a = UIDropdown2;
        this.b = textField2;
    }

    public final void action() {
        if (this.a.a != null && this.a.a.length != 0) {
            this.b.setText(this.a.b());
        }
    }
}
