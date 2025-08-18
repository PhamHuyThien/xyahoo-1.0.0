package home.thienph.xyahoo;

final class thien_cx
implements IAction {
    thien_cx(thien_cw thien_cw2) {
    }

    public final void action() {
        thien_di.instance.c();
        thien_di.instance.b(TextConstant.youWillReceiveYourPassword());
    }
}
