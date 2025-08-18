package home.thienph.xyahoo;

final class thien_co
implements IAction {
    private thien_cn a;

    thien_co(thien_cn thien_cn2) {
        this.a = thien_cn2;
    }

    public final void action() {
        String[] stringArray = this.a.e();
        MessageHandler.a(this.a.w, stringArray);
        GameManager.getInstance().i();
        GameManager.getInstance().a(this.a.w, stringArray, this.a.x);
    }
}
