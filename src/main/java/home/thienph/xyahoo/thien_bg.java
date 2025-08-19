package home.thienph.xyahoo;

final class thien_bg
implements IAction {
    private BigTwoGameScreen a;
    private final thien_ax b;

    thien_bg(BigTwoGameScreen bigTwoGameScreen2, thien_ax thien_ax2) {
        this.a = bigTwoGameScreen2;
        this.b = thien_ax2;
    }

    public final void action() {
        if (this.b.e) {
            this.b.e = false;
        }
        if (BigTwoGameScreen.currentGroupName.equals(this.a.D)) {
            this.a.P.g = true;
            MessageHandler.d(BigTwoGameScreen.B, BigTwoGameScreen.currentGroupName);
        }
    }
}
