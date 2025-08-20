package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;

final class thien_cx
implements IAction {
    thien_cx(thien_cw thien_cw2) {
    }

    public final void action() {
        GameManager.instance.closeTopDialog();
        GameManager.instance.showSimpleDialog(TextConstant.youWillReceiveYourPassword());
    }
}
