package home.thienph.xyahoo;

final class thien_ci
implements IAction {
    thien_ci(thien_ch thien_ch2) {
    }

    public final void action() {
        try {
            GameManager.instance.j.x.f.removeAllElements();
        }
        catch (Exception exception) {}
        if (GameManager.instance.k != null) {
            GameManager.instance.k.e();
        }
        GameManager.getInstance().c();
        GameManager.getInstance().g();
    }
}
