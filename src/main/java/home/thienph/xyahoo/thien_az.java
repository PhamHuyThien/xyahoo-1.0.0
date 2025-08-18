package home.thienph.xyahoo;

final class thien_az
implements IAction {
    private thien_ay a;

    thien_az(thien_ay thien_ay2) {
        this.a = thien_ay2;
    }

    public final void action() {
        String string = thien_ay.c[thien_ay.a((thien_ay)this.a)].a;
        if (thien_ay.b(this.a) == 1) {
            MessageHandler.a(string, thien_ba.z);
        }
    }
}
