package home.thienph.xyahoo;

public final class thien_cl
extends FormScreen {
    public TextField D;

    public thien_cl(String string, String string2) {
        this.isLocked = true;
        this.title = string;
        this.D = thien_y.b(this, string2, 0, -1);
        this.leftCommand = new UIAction(TextConstant.close(), new thien_cm(this));
        this.selectControl(this.D);
    }

    public final void a(IAction IAction2) {
        this.centerCommand = new UIAction("OK", IAction2);
    }
}
