package home.thienph.xyahoo;

final class thien_bq
implements IAction {
    private BigTwoGameScreen a;

    thien_bq(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        if (!BigTwoGameScreen.h().getText().equals("")) {
            long l;
            this.a.removeControl(BigTwoGameScreen.h());
            BigTwoGameScreen.H = false;
            this.a.selectControl(BigTwoGameScreen.g(this.a));
            try {
                l = Long.parseLong(BigTwoGameScreen.h().getText());
            }
            catch (Exception exception) {
                return;
            }
            if (BigTwoGameScreen.ah == 1) {
                MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.B, this.a.currentPlayerId, l);
            } else if (BigTwoGameScreen.ah == 3) {
                MessageHandler.a(BigTwoGameScreen.ah, BigTwoGameScreen.B, l);
            }
        }
        BigTwoGameScreen.a(this.a);
        BigTwoGameScreen.h().setText("");
    }
}
