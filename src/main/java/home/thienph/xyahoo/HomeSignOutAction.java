package home.thienph.xyahoo;

final class HomeSignOutAction
implements IAction {
    HomeSignOutAction(HomeScreen homeScreen2) {
    }

    public final void action() {
        GameManager.getInstance().a(TextConstant.areYouSure(), new ConfirmSignOutAction(this));
    }
}
