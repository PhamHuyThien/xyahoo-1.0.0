package home.thienph.xyahoo;

final class thien_cp
implements IAction {
    private thien_cn a;

    thien_cp(thien_cn thien_cn2) {
        this.a = thien_cn2;
    }

    public final void action() {
        thien_di.getInstance().i();
        MessageHandler.h(this.a.w);
    }
}
