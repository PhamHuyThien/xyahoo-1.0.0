package home.thienph.xyahoo;

final class thien_bt
implements IAction {
    private thien_ba a;

    thien_bt(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        if (thien_ba.ah == 1) {
            thien_bt thien_bt2 = this;
            thien_bt2.a.e();
            return;
        }
        thien_ba.e(thien_ba.ah);
    }
}
