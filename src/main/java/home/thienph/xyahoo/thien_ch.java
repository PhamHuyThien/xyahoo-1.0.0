package home.thienph.xyahoo;

final class thien_ch
implements IAction {
    thien_ch(thien_ca thien_ca2) {
    }

    public final void action() {
        GameManager.getInstance().a(TextConstant.areYouSure(), new thien_ci(this));
    }
}
