package home.thienph.xyahoo;

final class thien_m
implements IAction {
    thien_m() {
    }

    public final void action() {
        GameManager.getInstance().showEmoticonPicker(0);
    }
}
