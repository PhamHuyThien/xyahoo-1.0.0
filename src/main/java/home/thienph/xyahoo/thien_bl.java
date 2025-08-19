package home.thienph.xyahoo;

final class thien_bl
implements IAction {
    private BigTwoGameScreen a;

    thien_bl(BigTwoGameScreen bigTwoGameScreen2) {
        this.a = bigTwoGameScreen2;
    }

    public final void action() {
        thien_ax.B = false;
        if (!this.a.Y) {
            this.a.g();
        }
        long cfr_ignored_0 = this.a.ac;
        this.a.a((byte)this.a.Z, this.a.aa, this.a.ab, this.a.ad, this.a.ae, this.a.af, this.a.ag, BigTwoGameScreen.B);
    }
}
