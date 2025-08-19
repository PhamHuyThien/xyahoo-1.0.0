package home.thienph.xyahoo;

final class MenuLoginAction
implements IAction {
    private LoginScreen loginScreen;

    MenuLoginAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        GameManager.getInstance().showPopupSideLayout(this.loginScreen.menuPopupSide, 0);
    }
}
