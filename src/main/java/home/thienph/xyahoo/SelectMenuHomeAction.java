package home.thienph.xyahoo;

final class SelectMenuHomeAction
implements IAction {
    private HomeScreen homeScreen;

    SelectMenuHomeAction(HomeScreen homeScreen2) {
        this.homeScreen = homeScreen2;
    }

    public final void action() {
        UIGridMenu UIGridMenu2 = this.homeScreen.menuHome;
        int n = UIGridMenu2.selectedRow * UIGridMenu2.columns + UIGridMenu2.selectedCol;
        this.homeScreen.openMenu(n);
    }
}
