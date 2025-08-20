package home.thienph.xyahoo;

final class thien_gm
implements IAction {
    private final TextField a;
    private final UIDropdown b;
    private final Screen c;

    thien_gm(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2, Screen screen2) {
        this.a = textField2;
        this.b = UIDropdown2;
        this.c = screen2;
    }

    public final void action() {
        String string = this.a.getText().trim();
        if (string.equals("")) {
            return;
        }
        String string2 = this.b.b();
        MessageHandler.j(string2, string);
        GameManager.getInstance().removeScreen(this.c);
        GameManager.instance.focusBuddyList();
    }
}
