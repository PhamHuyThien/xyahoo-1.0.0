package home.thienph.xyahoo;

import java.util.Vector;

final class thien_cz
implements IAction {
    private LoginScreen a;

    thien_cz(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        int n;
        System.gc();
        this.a.usernameField.setText(this.a.usernameField.getText().toLowerCase());
        thien_ff.A = thien_ff.y = this.a.usernameField.getText();
        thien_ff.B = 1;
        Xuka.saveUserID(this.a.usernameField.getText());
        Xuka.savePassword(this.a.passwordField.getText());
        Xuka.saveFlag("status", true);
        if (thien_di.instance.j == null) {
            thien_di.instance.j = new thien_ff();
            thien_di.instance.m = new thien_cn();
        }
        if ((n = thien_di.a(false)) != -1) {
            thien_s thien_s2 = thien_di.a(false, thien_ff.y);
            if (thien_s2 != null) {
                thien_di.getInstance().j.x.a(thien_s2, -1);
            } else {
                n = -1;
            }
        }
        thien_di.getInstance().d = new Vector();
        GameCanvas.instance.connectToServer();
        MessageHandler.a(this.a.usernameField.getText(), this.a.passwordField.getText(), thien_ff.B, 1, n);
    }
}
