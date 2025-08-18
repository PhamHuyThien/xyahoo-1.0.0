package home.thienph.xyahoo;

final class thien_bu
implements IAction {
    thien_bu(thien_ba thien_ba2) {
    }

    public final void action() {
        if (thien_ba.ah == 1) {
            MessageHandler.d(thien_ba.ai);
            return;
        }
        MessageHandler.a(thien_ba.ah, thien_ba.ai);
    }
}
