package home.thienph.xyahoo;

final class DeleteCharBeforeCursorAction
implements IAction {
    private TextField textField;

    DeleteCharBeforeCursorAction(TextField textField2) {
        this.textField = textField2;
    }

    public final void action() {
        this.textField.deleteCharBeforeCursor();
    }
}
