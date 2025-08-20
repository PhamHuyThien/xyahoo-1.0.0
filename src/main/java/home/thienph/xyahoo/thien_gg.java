package home.thienph.xyahoo;

final class thien_gg
implements IAction {
    thien_gg(BuddyListScreen buddyListScreen2) {
    }

    public final void action() {
        GameManager.getInstance().removeScreen(GameManager.instance.buddyListScreen);
    }
}
