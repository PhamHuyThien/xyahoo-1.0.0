package home.thienph.xyahoo;

final class thien_bi
implements IAction {
    final thien_bh a;

    thien_bi(thien_bh thien_bh2) {
        this.a = thien_bh2;
    }

    public final void action() {
        GameManager.getInstance().c();
        GameManager.instance.a("Bạn có muốn rời bàn?", new thien_bj(this));
    }
}
