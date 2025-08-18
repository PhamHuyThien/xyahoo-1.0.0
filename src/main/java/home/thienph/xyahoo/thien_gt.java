package home.thienph.xyahoo;

final class thien_gt
implements IAction {
    private thien_gp a;

    thien_gt(thien_gp thien_gp2) {
        this.a = thien_gp2;
    }

    public final void action() {
        int n;
        String string = thien_fe.b(thien_gp.b(this.a).getText().trim());
        int n2 = n = thien_gp.c(this.a).a() == 0 ? 0 : 12;
        if (string != null && !string.equals(thien_gp.A)) {
            thien_gp.a(this.a, string);
            thien_gp.z = 0;
            GameManager.z = true;
        } else if (n != thien_gp.z) {
            if (n == 0) {
                if (string != null && string.length() > 0) {
                    thien_gp.a(this.a, string);
                } else {
                    MessageHandler.a(0, 2);
                }
                thien_gp.z = 0;
                GameManager.z = true;
            } else {
                MessageHandler.a(12, 2);
                thien_gp.z = 12;
                GameManager.z = true;
            }
        }
        GameManager.getInstance().c(thien_gp.d(this.a));
    }
}
