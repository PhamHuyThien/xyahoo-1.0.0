package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.main.Xuka;

public final class CallAction
implements IAction {
    public CallAction() {
    }

    public final void action() {
        Xuka.instance.callPhone("0969728701");
    }
}
