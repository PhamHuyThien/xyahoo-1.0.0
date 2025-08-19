package home.thienph.xyahoo;

final class ForgetPasswordAction
implements IAction {
    private LoginScreen loginScreen;

    ForgetPasswordAction(LoginScreen loginScreen2) {
        this.loginScreen = loginScreen2;
    }

    public final void action() {
        LoginScreen.removeCommentField(this.loginScreen);
        if (this.loginScreen.usernameField.getText().equals("")) {
            GameManager.getInstance().showCenterPopup(TextConstant.enterYourYahooId());
            return;
        }
        GameCanvas.instance.connectToServer();
        MessageHandler.b();
        Packet packet2 = new Packet(269, 13);
        ConnectionManager.sendPacket(packet2);
        GameManager.getInstance().showCenterPopup(TextConstant.pleaseWait());
    }
}
