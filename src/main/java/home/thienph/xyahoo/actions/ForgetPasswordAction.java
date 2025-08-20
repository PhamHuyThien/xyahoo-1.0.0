package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.networks.Packet;
import home.thienph.xyahoo.conections.ConnectionManager;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.LoginScreen;
import home.thienph.xyahoo.main.*;

public final class ForgetPasswordAction
implements IAction {
    private LoginScreen loginScreen;

    public ForgetPasswordAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        if (this.loginScreen.usernameField.getText().equals("")) {
            GameManager.getInstance().showSimpleDialog(TextConstant.enterYourYahooId());
            return;
        }
        GameCanvas.instance.connectToServer();
        MessageHandler.b();
        Packet packet2 = new Packet(269, 13);
        ConnectionManager.sendPacket(packet2);
        GameManager.getInstance().showSimpleDialog(TextConstant.pleaseWait());
    }
}
