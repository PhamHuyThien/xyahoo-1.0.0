package home.thienph.xyahoo;

final class thien_fq
implements IAction {
    private BuddyListScreen a;
    private final thien_cl b;

    thien_fq(BuddyListScreen buddyListScreen2, thien_cl thien_cl2) {
        this.a = buddyListScreen2;
        this.b = thien_cl2;
    }

    public final void action() {
        GameCanvas.resetKeys();
        String string = this.b.D.getText().trim();
        if (string.equals("")) {
            return;
        }
        GameManager.getInstance().removeScreen(this.b);
        this.a.handleChatAction(string, 0);
    }
}
