package home.thienph.xyahoo;

final class thien_cg
implements IAction {
    private thien_ce a;

    thien_cg(thien_ce thien_ce2) {
        this.a = thien_ce2;
    }

    public final void action() {
        thien_ce thien_ce2 = this.a;
        thien_ca.a(thien_ce2.a);
        thien_ce2 = this.a;
        MessageHandler.c(thien_ce2.a.F.getText());
    }
}
