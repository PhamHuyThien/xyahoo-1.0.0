package home.thienph.xyahoo;

final class OpenMenuHomeAction
implements IAction {
    private HomeScreen homeScreen;

    OpenMenuHomeAction(HomeScreen homeScreen2) {
        this.homeScreen = homeScreen2;
    }

    public final void action() {
        GameManager.getInstance().showPopupSideLayout(this.homeScreen.E, 0);
    }
}
