package home.thienph.xyahoo;

final class thien_cc
implements IAction {
    private thien_ca a;

    thien_cc(thien_ca thien_ca2) {
        this.a = thien_ca2;
    }

    public final void action() {
        UIGridMenu UIGridMenu2 = this.a.H;
        int n = UIGridMenu2.selectedRow * UIGridMenu2.columns + UIGridMenu2.selectedCol;
        this.a.e(n);
    }
}
