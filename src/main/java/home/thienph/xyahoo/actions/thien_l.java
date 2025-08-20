package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;

public final class thien_l
implements IAction {
    private final String a;
    private final String b;

    public thien_l(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    public final void action() {
        GameManager.instance.closeTopDialog();
        GameManager.instance.showSimpleDialog(TextConstant.pleaseWait());
        Xuka.startThread(this.a, this.b, null, null, true);
    }
}
