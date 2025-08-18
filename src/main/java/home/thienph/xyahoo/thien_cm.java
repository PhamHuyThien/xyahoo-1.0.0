package home.thienph.xyahoo;

final class thien_cm
implements IAction {
    private thien_cl a;

    thien_cm(thien_cl thien_cl2) {
        this.a = thien_cl2;
    }

    public final void action() {
        GameManager.instance.c(this.a);
    }
}
