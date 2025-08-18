package home.thienph.xyahoo;

final class thien_be
implements IAction {
    private thien_ba a;

    thien_be(thien_ba thien_ba2) {
        this.a = thien_ba2;
    }

    public final void action() {
        if (this.a.centerCommand.label.equals(TextConstant.playNow())) {
            MessageHandler.c(thien_ba.B, thien_ba.z);
        }
    }
}
