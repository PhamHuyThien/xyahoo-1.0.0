package home.thienph.xyahoo;

final class thien_n
implements IAction {
    private final PopupSideElementData a;

    thien_n(PopupSideElementData popupSideElementData2) {
        this.a = popupSideElementData2;
    }

    public final void action() {
        GameManager.getInstance().showSideMenu(this.a, 0);
    }
}
