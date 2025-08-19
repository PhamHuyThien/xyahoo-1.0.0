package home.thienph.xyahoo;

final class ConfirmSignOutAction
implements IAction {
    ConfirmSignOutAction(HomeSignOutAction homeSignOutAction2) {
    }

    public final void action() {
        try {
            GameManager.instance.buddyListScreen.buddyList.actionButtons.removeAllElements();
        }
        catch (Exception exception) {}
        if (GameManager.instance.loginYahooScreen != null) {
            GameManager.instance.loginYahooScreen.e();
        }
        GameManager.getInstance().c();
        GameManager.getInstance().g();
    }
}
