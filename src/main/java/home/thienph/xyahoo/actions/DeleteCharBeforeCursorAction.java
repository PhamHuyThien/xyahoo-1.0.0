package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;

public final class DeleteCharBeforeCursorAction
implements IAction {
    private TextField textField;

    public DeleteCharBeforeCursorAction(TextField textField2) {
        this.textField = textField2;
    }

    public final void action() {
        this.textField.deleteCharBeforeCursor();
    }
}
