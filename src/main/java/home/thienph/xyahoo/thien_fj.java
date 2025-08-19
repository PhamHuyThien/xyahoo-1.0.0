package home.thienph.xyahoo;

final class thien_fj
implements IAction {
    private final TextField a;
    private final UIDropdown b;

    thien_fj(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2) {
        this.a = textField2;
        this.b = UIDropdown2;
    }

    public final void action() {
        this.a.setText(this.b.b());
    }
}
