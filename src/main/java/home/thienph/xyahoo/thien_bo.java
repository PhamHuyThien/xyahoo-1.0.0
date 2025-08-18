package home.thienph.xyahoo;

final class thien_bo
        implements IAction {
    private thien_ba a;

    thien_bo(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        this.a.removeControl(thien_ba.I);
        thien_ba.J = false;
        this.a.selectControl(thien_ba.g(this.a));
        if (thien_ba.ah == 1) {
            MessageHandler.a(thien_ba.ah, thien_ba.B, thien_ba.z, thien_ba.I.getText());
        }
        thien_ba.a(this.a);
        thien_ba.I.setText("");
    }
}
