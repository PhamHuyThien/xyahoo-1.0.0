package home.thienph.xyahoo;

final class thien_ce
implements IAction {
    final thien_ca a;

    thien_ce(thien_ca thien_ca2) {
        this.a = thien_ca2;
    }

    public final void action() {
        this.a.G = true;
        if (this.a.F == null) {
            this.a.F = new TextField("", 250, 0);
            this.a.F.isEditable = false;
            this.a.F.setBounds(0, Screen.formHeight - (TextRenderer.fontHeight << 1) + 8, Screen.e - 1, TextRenderer.fontHeight + 6);
            this.a.F.actionPrimary = new UIAction(TextConstant.exit(), new thien_cf(this));
            this.a.F.actionTertiary = new UIAction(TextConstant.send(), new thien_cg(this));
        } else {
            this.a.F.setText("");
        }
        this.a.addControl(this.a.F);
        this.a.selectControl(this.a.F);
    }
}
