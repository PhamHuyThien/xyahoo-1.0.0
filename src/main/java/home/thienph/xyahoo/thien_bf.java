package home.thienph.xyahoo;

final class thien_bf
implements IAction {
    private BigTwoGameScreen a;

    thien_bf(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (this.a.centerCommand.label.equals(TextConstant.ready())) {
            int n = 0;
            while (n < this.a.F.length) {
                if (this.a.F[n].a.equals(BigTwoGameScreen.currentGroupName)) {
                    this.a.centerCommand.label = "";
                    MessageHandler.b(BigTwoGameScreen.B, BigTwoGameScreen.currentGroupName);
                }
                ++n;
            }
        }
    }
}
