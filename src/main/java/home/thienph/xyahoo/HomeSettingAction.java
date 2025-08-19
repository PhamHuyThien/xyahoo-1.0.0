package home.thienph.xyahoo;

final class HomeSettingAction
implements IAction {
    HomeSettingAction(HomeScreen homeScreen2) {
    }

    public final void action() {
        LoginScreen.openSettings();
    }
}
