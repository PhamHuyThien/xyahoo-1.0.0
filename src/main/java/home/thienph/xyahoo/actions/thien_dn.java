package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;

final class thien_dn
implements IAction {
    private thien_dm a;

    thien_dn(thien_dm thien_dm2) {
        this.a = thien_dm2;
    }

    public final void action() {
        thien_dm thien_dm2 = this.a;
        thien_dm2.gameManager.closeTopDialog();
        thien_dm2 = this.a;
        thien_dm2.gameManager.showSimpleDialog(TextConstant.pleaseWaitForTheReturnActiveSms());
    }
}
