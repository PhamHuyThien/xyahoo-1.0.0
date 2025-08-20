package home.thienph.xyahoo;

final class thien_fk
implements IAction {
    private final TextField a;
    private final Screen b;
    private final String c;
    private final String d;

    thien_fk(BuddyListScreen buddyListScreen2, TextField textField2, Screen screen2, String string, String string2) {
        this.a = textField2;
        this.b = screen2;
        this.c = string;
        this.d = string2;
    }

    public final void action() {
        String string = this.a.getText().trim();
        if (string.equals("")) {
            this.b.selectControl(this.a);
            return;
        }
        GameManager.instance.focusBuddyList();
        if (string.equals(this.c)) {
            GameManager.getInstance().removeScreen(this.b);
            return;
        }
        MessageHandler.g(this.d, string);
        GameManager.getInstance().removeScreen(this.b);
    }
}
