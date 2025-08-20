package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.InviteConferenceScreen;
import home.thienph.xyahoo.screens.LoginScreen;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.main.Xuka;

import java.util.Vector;

public final class LoginAction
implements IAction {
    private LoginScreen loginScreen;

    public LoginAction(LoginScreen loginScreen) {
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
        if ((n = GameManager.getChecksumValue(false)) != -1) {
            ContactDataSource contactDataSource2 = GameManager.loadBuddyList(false, BuddyListScreen.currentGroupName);
            if (contactDataSource2 != null) {
                GameManager.getInstance().buddyListScreen.buddyList.setDataSource(contactDataSource2, -1);
            } else {
                n = -1;
            }
        }
        GameManager.getInstance().messageQueue = new Vector();
        GameCanvas.instance.connectToServer();
        MessageHandler.login(this.loginScreen.usernameField.getText(), this.loginScreen.passwordField.getText(), BuddyListScreen.userStatus, 1, n);
//        GameManager.getInstance().showHomeScreen();
    }
}
