package home.thienph.xyahoo;

final class thien_el
implements IAction {
    private thien_eh a;

    thien_el(thien_eh thien_eh2) {
        this.a = thien_eh2;
    }

    public final void action() {
        GameCanvas.instance.connectToServer();
        thien_eh.a(this.a, this.a.D.getText());
        this.a.F = this.a.E.getText();
        MessageHandler.e(this.a.G, this.a.E.getText());
    }
}
