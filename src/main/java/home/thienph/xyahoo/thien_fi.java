package home.thienph.xyahoo;

final class thien_fi
implements IAction {
    private final PopupSideElementData a;

    thien_fi(thien_ff thien_ff2, PopupSideElementData popupSideElementData2) {
        this.a = popupSideElementData2;
    }

    public final void action() {
        GameManager.getInstance().showPopupSideLayout(this.a, 0);
    }
}
