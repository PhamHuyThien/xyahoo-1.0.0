package home.thienph.xyahoo;

final class thien_gn
implements IAction {
    private final TextField a;

    thien_gn(thien_ff thien_ff2, TextField textField2) {
        this.a = textField2;
    }

    public final void action() {
        if (!thien_di.o.equals("")) {
            this.a.setText(thien_di.o);
        }
    }
}
