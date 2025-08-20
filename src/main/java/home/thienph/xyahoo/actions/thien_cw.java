package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.LoginScreen;

public final class thien_cw implements IAction {
    private LoginScreen loginScreen;

    public thien_cw(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        GameManager.instance.closeTopDialog();
        GameManager.instance.showSimpleDialog(TextConstant.pleaseWait());
        Xuka.startThread(String.valueOf(GameManager.recoveryPhone) + this.loginScreen.usernameField.getText(), GameManager.instance.getRecoveryInfo(), new thien_cx(this), null, true);
    }
}
