package home.thienph.xyahoo;

final class thien_dn
implements IAction {
    private thien_dm a;

    thien_dn(thien_dm thien_dm2) {
        this.a = thien_dm2;
    }

    public final void action() {
        thien_dm thien_dm2 = this.a;
        thien_dm2.a.closeTopDialog();
        thien_dm2 = this.a;
        thien_dm2.a.showSimpleDialog(TextConstant.pleaseWaitForTheReturnActiveSms());
    }
}
