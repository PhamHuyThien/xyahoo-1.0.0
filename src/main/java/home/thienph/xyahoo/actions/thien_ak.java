package home.thienph.xyahoo.actions;

public final class thien_ak
implements IAction {
    private thien_aj a;

    public thien_ak(thien_aj thien_aj2) {
        this.a = thien_aj2;
    }

    public final void action() {
        this.a.action.action();
    }
}
