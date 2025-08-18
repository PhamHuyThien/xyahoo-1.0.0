package home.thienph.xyahoo;

final class thien_dr
implements IAction {
    private thien_di a;
    private final TextField b;
    private final String c;
    private final FormScreen d;

    thien_dr(thien_di thien_di2, TextField textField2, String string, FormScreen formScreen2) {
        this.a = thien_di2;
        this.b = textField2;
        this.c = string;
        this.d = formScreen2;
    }

    public final void action() {
        MessageHandler.a(false, this.b.getText(), this.c);
        this.a.c(this.d);
    }
}
