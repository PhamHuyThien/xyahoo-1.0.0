package home.thienph.xyahoo;

final class thien_fs
implements IAction {
    private final thien_cl a;

    thien_fs(BuddyListScreen buddyListScreen2, thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.a.D.getText().trim();
        if (string.trim().equals("")) {
            return;
        }
        GameManager.getInstance().removeScreen(this.a);
        BuddyListScreen.userFullName = string;
        BuddyListScreen.userStatusMessage = BuddyListScreen.userFullName.equals("") ? BuddyListScreen.currentGroupName : BuddyListScreen.userFullName;
        MessageHandler.b(string, "", "");
        GameManager.instance.focusBuddyList();
    }
}
