package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

final class thien_gv
        implements IAction {
    private LoginYahooScreen a;

    thien_gv(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        if (!this.a.C) {
            GameManager.instance.showNotification(TextConstant.pleaseWait(), (Image)null, 1);
            return;
        }
        LoginYahooScreen.a(this.a);
    }
}
