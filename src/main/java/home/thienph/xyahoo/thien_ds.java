package home.thienph.xyahoo;

final class thien_ds
implements IAction {
    private GameManager a;
    private final TextField b;
    private final String c;
    private final FormScreen d;

    thien_ds(GameManager gameManager2, TextField textField2, String string, FormScreen formScreen2) {
        this.a = gameManager2;
        this.b = textField2;
        this.c = string;
        this.d = formScreen2;
    }

    public final void action() {
        if (this.b.getText().equals("")) {
            return;
        }
        this.a.buddyListScreen.buddyList.getDataModel().a(this.b.getText(), new thien_r(this.c, "", 0, "", new int[0], 0, 0));
        this.a.buddyListScreen.buddyList.c();
        BuddyListScreen buddyListScreen2 = this.a.buddyListScreen;
        buddyListScreen2.buddyList.d();
        MessageHandler.a(true, this.b.getText(), this.c);
        this.a.c(this.d);
    }
}
