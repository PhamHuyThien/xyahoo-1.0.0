package home.thienph.xyahoo;

final class thien_fg
implements IAction {
    private BuddyListScreen a;
    private final thien_cl b;
    private final String c;

    thien_fg(BuddyListScreen buddyListScreen2, thien_cl thien_cl2, String string) {
        this.a = buddyListScreen2;
        this.b = thien_cl2;
        this.c = string;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.b.D.getText().trim();
        if (string.equals("")) {
            return;
        }
        if (this.a.buddyList.c(string)) {
            GameManager.getInstance().showSimpleDialog(TextConstant.thisGroupNameAlreadyExist());
            return;
        }
        MessageHandler.h(this.c, string);
        GameManager.getInstance().removeScreen(this.b);
        GameManager.instance.focusBuddyList();
    }
}
