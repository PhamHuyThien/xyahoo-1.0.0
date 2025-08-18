package home.thienph.xyahoo;

final class thien_dd
implements IAction {
    private LoginScreen a;

    thien_dd(LoginScreen loginScreen2) {
        this.a = loginScreen2;
    }

    public final void action() {
        LoginScreen.closeChatBox(this.a);
        if (this.a.usernameField.getText().equals("")) {
            thien_di.getInstance().b(TextConstant.enterYourYahooId());
            return;
        }
        GameCanvas.instance.connectToServer();
        MessageHandler.b();
        Packet packet2 = new Packet(269, 13);
        thien_hc.a(packet2);
        thien_di.getInstance().b(TextConstant.pleaseWait());
    }
}
