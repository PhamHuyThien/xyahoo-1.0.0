package home.thienph.xyahoo;

final class thien_gt
implements IAction {
    private LoginYahooScreen a;

    thien_gt(LoginYahooScreen loginYahooScreen2) {
        this.a = loginYahooScreen2;
    }

    public final void action() {
        int n;
        String string = ContentFilter.filterProfanity(LoginYahooScreen.b(this.a).getText().trim());
        int n2 = n = LoginYahooScreen.c(this.a).a() == 0 ? 0 : 12;
        if (string != null && !string.equals(LoginYahooScreen.A)) {
            LoginYahooScreen.a(this.a, string);
            LoginYahooScreen.z = 0;
            GameManager.isShowingAnimation = true;
        } else if (n != LoginYahooScreen.z) {
            if (n == 0) {
                if (string != null && string.length() > 0) {
                    LoginYahooScreen.a(this.a, string);
                } else {
                    MessageHandler.a(0, 2);
                }
                LoginYahooScreen.z = 0;
                GameManager.isShowingAnimation = true;
            } else {
                MessageHandler.a(12, 2);
                LoginYahooScreen.z = 12;
                GameManager.isShowingAnimation = true;
            }
        }
        GameManager.getInstance().removeScreen(LoginYahooScreen.d(this.a));
    }
}
