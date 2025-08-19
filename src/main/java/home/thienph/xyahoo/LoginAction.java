package home.thienph.xyahoo;

import java.util.Vector;

final class LoginAction
implements IAction {
    private LoginScreen loginScreen;

    LoginAction(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public final void action() {
        int n;
        System.gc();
        this.loginScreen.usernameField.setText(this.loginScreen.usernameField.getText().toLowerCase());
        BuddyListScreen.userStatusMessage = BuddyListScreen.currentGroupName = this.loginScreen.usernameField.getText();
        BuddyListScreen.userStatus = 1;
        Xuka.saveUserID(this.loginScreen.usernameField.getText());
        Xuka.savePassword(this.loginScreen.passwordField.getText());
        Xuka.saveFlag("status", true);
        if (GameManager.instance.buddyListScreen == null) {
            GameManager.instance.buddyListScreen = new BuddyListScreen();
            GameManager.instance.inviteConferenceScreen = new InviteConferenceScreen();
        }
        if ((n = GameManager.a(false)) != -1) {
            thien_s thien_s2 = GameManager.a(false, BuddyListScreen.currentGroupName);
            if (thien_s2 != null) {
                GameManager.getInstance().buddyListScreen.buddyList.a(thien_s2, -1);
            } else {
                n = -1;
            }
        }
        GameManager.getInstance().d = new Vector();
        GameCanvas.instance.connectToServer();
        MessageHandler.login(this.loginScreen.usernameField.getText(), this.loginScreen.passwordField.getText(), BuddyListScreen.userStatus, 1, n);
        GameManager.getInstance().showHomeScreen();
    }
}
