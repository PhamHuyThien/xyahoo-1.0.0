package home.thienph.xyahoo;

final class CommentAction implements IAction {
    private LoginScreen loginScreen;

    CommentAction(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public final void action() {
        this.loginScreen.addControl(this.loginScreen.commentField);
        this.loginScreen.selectControl(this.loginScreen.commentField);
    }
}
