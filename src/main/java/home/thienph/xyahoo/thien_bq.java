package home.thienph.xyahoo;

final class thien_bq
implements IAction {
    private thien_ba a;

    thien_bq(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        if (!thien_ba.h().getText().equals("")) {
            long l;
            this.a.removeControl(thien_ba.h());
            thien_ba.H = false;
            this.a.selectControl(thien_ba.g(this.a));
            try {
                l = Long.parseLong(thien_ba.h().getText());
            }
            catch (Exception exception) {
                return;
            }
            if (thien_ba.ah == 1) {
                MessageHandler.a(thien_ba.ah, thien_ba.B, this.a.w, l);
            } else if (thien_ba.ah == 3) {
                MessageHandler.a(thien_ba.ah, thien_ba.B, l);
            }
        }
        thien_ba.a(this.a);
        thien_ba.h().setText("");
    }
}
