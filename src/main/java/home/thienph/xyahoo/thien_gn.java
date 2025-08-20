package home.thienph.xyahoo;

final class thien_gn
implements IAction {
    private final TextField a;

    thien_gn(BuddyListScreen buddyListScreen2, TextField textField2) {
        this.a = textField2;
    }

    public final void action() {
        if (!GameManager.statusMessage.equals("")) {
            this.a.setText(GameManager.statusMessage);
        }
    }
}
