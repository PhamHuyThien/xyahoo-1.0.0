package home.thienph.xyahoo;

import java.util.Vector;

final class LoginAction
implements IAction {
    private LoginScreen loginScreen;

    LoginAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        int n;
        System.gc();
        this.loginScreen.usernameField.setText(this.loginScreen.usernameField.getText().toLowerCase());
        thien_ff.A = thien_ff.y = this.loginScreen.usernameField.getText();
        thien_ff.B = 1;
        Xuka.saveUserID(this.loginScreen.usernameField.getText());
        Xuka.savePassword(this.loginScreen.passwordField.getText());
        Xuka.saveFlag("status", true);
        if (GameManager.instance.j == null) {
            GameManager.instance.j = new thien_ff();
            GameManager.instance.m = new thien_cn();
        }
        if ((n = GameManager.a(false)) != -1) {
            thien_s thien_s2 = GameManager.a(false, thien_ff.y);
            if (thien_s2 != null) {
                GameManager.getInstance().j.x.a(thien_s2, -1);
            } else {
                n = -1;
            }
        }
        GameManager.getInstance().d = new Vector();
        GameCanvas.instance.connectToServer();
        MessageHandler.login(this.loginScreen.usernameField.getText(), this.loginScreen.passwordField.getText(), thien_ff.B, 1, n);
    }
}
