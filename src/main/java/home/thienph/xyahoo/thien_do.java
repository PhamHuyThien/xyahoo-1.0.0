package home.thienph.xyahoo;

final class thien_do
implements IAction {
    private thien_dm a;
    private final IAction b;

    thien_do(thien_dm thien_dm2, IAction IAction2) {
        this.a = thien_dm2;
        this.b = IAction2;
    }

    public final void action() {
        thien_dm thien_dm2 = this.a;
        thien_dm2.a.closeTopDialog();
        thien_dm2 = this.a;
        thien_dm2.a.showInfoDialog(TextConstant.sendSmsFailed(), this.b);
    }
}
