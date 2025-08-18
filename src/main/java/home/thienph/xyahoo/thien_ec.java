package home.thienph.xyahoo;

final class thien_ec
implements IAction {
    private thien_di a;

    thien_ec(thien_di thien_di2) {
        this.a = thien_di2;
    }

    public final void action() {
        System.out.println("ccoooooooooooooo");
        this.a.c();
    }
}
