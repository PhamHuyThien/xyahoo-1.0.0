package home.thienph.xyahoo;

final class CallAction
implements IAction {
    CallAction() {
    }

    public final void action() {
        Xuka.instance.callPhone("0969728701");
    }
}
