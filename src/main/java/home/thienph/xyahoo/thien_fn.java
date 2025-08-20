package home.thienph.xyahoo;

final class thien_fn
implements IAction {
    private final TextField a;
    private final UIDropdown b;
    private final Screen c;

    thien_fn(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2, Screen screen2) {
        this.a = textField2;
        this.b = UIDropdown2;
        this.c = screen2;
    }

    public final void action() {
        String string = ContentFilter.filterProfanity(this.a.getText().trim());
        int n = this.b.a() == 0 ? 1 : 0;
        if (n != BuddyListScreen.userStatus) {
            MessageHandler.a(n, 1);
            BuddyListScreen.userStatus = n;
        }
        if (BuddyListScreen.userStatus == 1) {
            MessageHandler.a(string, 1);
            BuddyListScreen.tempStatusMessage = string;
            Xuka.saveCustomStr(BuddyListScreen.currentGroupName, BuddyListScreen.tempStatusMessage, false);
        }
        GameManager.getInstance().removeScreen(this.c);
        GameManager.instance.focusBuddyList();
    }
}
