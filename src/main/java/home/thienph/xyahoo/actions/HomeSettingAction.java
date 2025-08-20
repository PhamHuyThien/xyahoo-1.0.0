package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.screens.HomeScreen;
import home.thienph.xyahoo.screens.LoginScreen;

public final class HomeSettingAction
implements IAction {
    public HomeSettingAction(HomeScreen homeScreen2) {
    }

    public final void action() {
        LoginScreen.openSettings();
    }
}
