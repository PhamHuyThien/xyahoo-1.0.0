package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

final class thien_fp
implements IAction {
    private BuddyListScreen a;
    private final TextField b;
    private final TextField c;
    private final TextField d;
    private final Screen e;

    thien_fp(BuddyListScreen buddyListScreen2, TextField textField2, TextField textField3, TextField textField4, Screen screen2) {
        this.a = buddyListScreen2;
        this.b = textField2;
        this.c = textField3;
        this.d = textField4;
        this.e = screen2;
    }

    public final void action() {
        if (this.b.getText().equals("")) {
            return;
        }
        if (this.c.getText().length() < 6 || this.c.getText().length() > 64) {
            GameManager.getInstance().a(String.valueOf(TextConstant.password()) + TextConstant.lengthMustBeFrom6To64(), (Image)null, 1);
            this.a.selectControl(this.c);
            return;
        }
        if (this.c.getText().equals("") || this.d.getText().equals("") || !this.c.getText().equals(this.d.getText())) {
            GameManager.getInstance().a(TextConstant.typePasswordAgain(), (Image)null, 1);
            this.a.selectControl(this.c);
            return;
        }
        MessageHandler.b("", this.b.getText(), this.c.getText());
        GameManager.getInstance().c(this.e);
        GameManager.instance.l();
    }
}
