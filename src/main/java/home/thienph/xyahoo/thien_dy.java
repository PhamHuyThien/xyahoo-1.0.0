package home.thienph.xyahoo;

final class thien_dy
implements IAction {
    private GameManager a;
    private final String b;

    thien_dy(GameManager gameManager2, String string) {
        this.a = gameManager2;
        this.b = string;
    }

    public final void action() {
        MessageHandler.c(LoginYahooScreen.x, this.b, 1);
        this.a.closeTopDialog();
    }
}
