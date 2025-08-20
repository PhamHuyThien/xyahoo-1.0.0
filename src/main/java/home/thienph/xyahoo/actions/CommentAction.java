package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.LoginScreen;

public final class CommentAction implements IAction {
    private LoginScreen loginScreen;

    public CommentAction(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public final void action() {
        this.loginScreen.addControl(this.loginScreen.commentField);
        this.loginScreen.selectControl(this.loginScreen.commentField);
    }
}
