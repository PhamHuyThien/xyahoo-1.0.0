package home.thienph.xyahoo.actions;

final class thien_ah
implements IAction {
    private thien_ag a;

    thien_ah(thien_ag thien_ag2) {
        this.a = thien_ag2;
    }

    public final void action() {
        this.a.handleKeyPress(0, 0);
    }
}
