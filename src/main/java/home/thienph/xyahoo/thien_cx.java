package home.thienph.xyahoo;

final class thien_cx
implements IAction {
    thien_cx(thien_cw thien_cw2) {
    }

    public final void action() {
        GameManager.instance.c();
        GameManager.instance.b(TextConstant.youWillReceiveYourPassword());
    }
}
