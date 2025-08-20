package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.screens.HomeScreen;
import home.thienph.xyahoo.constants.TextConstant;

public final class HomeSignOutAction
implements IAction {
    public HomeSignOutAction(HomeScreen homeScreen2) {
    }

    public final void action() {
        GameManager.getInstance().showConfirmDialog(TextConstant.areYouSure(), new ConfirmSignOutAction(this));
    }
}
