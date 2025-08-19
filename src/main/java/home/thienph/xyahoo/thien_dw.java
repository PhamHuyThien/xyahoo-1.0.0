package home.thienph.xyahoo;

final class thien_dw
implements IAction {
    private GameManager a;
    private final TextField b;
    private final Screen c;
    private final UIDropdown d;

    thien_dw(GameManager gameManager2, TextField textField2, Screen screen2, UIDropdown UIDropdown2) {
        this.a = gameManager2;
        this.b = textField2;
        this.c = screen2;
        this.d = UIDropdown2;
    }

    public final void action() {
        String string = this.b.getText();
        if (string.equals("")) {
            this.c.selectControl(this.b);
            return;
        }
        GameManager.t.addElement(string);
        MessageHandler.i(BuddyListScreen.currentGroupName, string);
        int n = 0;
        while (n < this.d.a.length) {
            if (string.equals(this.d.a[n])) {
                this.a.showCenterPopup(String.valueOf(TextConstant.deleteSuccess()) + string);
                this.a.c(this.c);
                this.a.k();
                return;
            }
            ++n;
        }
        this.a.showCenterPopup(String.valueOf(TextConstant.add2()) + string + TextConstant.success());
        this.a.c(this.c);
        this.a.k();
    }
}
