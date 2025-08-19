package home.thienph.xyahoo;

final class ExitAction
implements IAction {
    ExitAction(LoginScreen loginScreen2) {
    }

    public final void action() {
        Xuka.instance.stopApp();
    }
}
