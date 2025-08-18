package home.thienph.xyahoo;

final class thien_bi
implements IAction {
    final thien_bh a;

    thien_bi(thien_bh thien_bh2) {
        this.a = thien_bh2;
    }

    public final void action() {
        GameManager.getInstance().c();
        GameManager.instance.a("B\u1ea1n c\u00f3 mu\u1ed1n r\u1eddi b\u00e0n?", new thien_bj(this));
    }
}
