package home.thienph.xyahoo;

final class thien_dz
implements IAction {
    private thien_di a;
    private final String b;

    thien_dz(thien_di thien_di2, String string) {
        this.a = thien_di2;
        this.b = string;
    }

    public final void action() {
        MessageHandler.c(thien_gp.x, this.b, 0);
        this.a.c();
    }
}
