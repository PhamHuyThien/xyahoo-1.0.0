package home.thienph.xyahoo;

final class thien_av
implements IAction {
    private TextField a;

    thien_av(TextField textField2) {
        this.a = textField2;
    }

    public final void action() {
        this.a.deleteCharBeforeCursor();
    }
}
