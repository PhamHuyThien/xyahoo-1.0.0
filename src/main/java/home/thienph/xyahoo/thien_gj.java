package home.thienph.xyahoo;

final class thien_gj
implements IAction {
    private final TextField a;
    private final UIDropdown b;

    thien_gj(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2) {
        this.a = textField2;
        this.b = UIDropdown2;
    }

    public final void action() {
        this.a.setText(this.b.b());
    }
}
