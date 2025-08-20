package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;

public final class thien_ga
implements IAction {
    private BuddyListScreen buddyListScreen;

    public thien_ga(BuddyListScreen buddyListScreen2) {
        this.buddyListScreen = buddyListScreen2;
    }

    public final void action() {
        boolean bl;
        thien_u thien_u2;
        block6: {
            thien_u2 = this.buddyListScreen.buddyList.h();
            if (thien_u2 == null) {
                return;
            }
            if (thien_u2.a == 0) {
                if (thien_u2.g == 3) {
                    return;
                }
                this.buddyListScreen.buddyList.g();
                MessageHandler.f(thien_u2.d);
                return;
            }
            String string = thien_u2.d;
            thien_s thien_s2 = this.buddyListScreen.buddyList.getDataModel();
            int n = thien_s2.a.size() - 1;
            while (n >= 0) {
                thien_t thien_t2 = (thien_t)thien_s2.a.elementAt(n);
                if (thien_t2.a().equals(string)) {
                    bl = thien_t2.a.size() == 0;
                    break block6;
                }
                --n;
            }
            bl = false;
        }
        if (bl) {
            MessageHandler.e(thien_u2.d);
            GameManager.getInstance().buddyListScreen.buddyList.a(thien_u2.d);
            return;
        }
        GameManager.getInstance().showSimpleDialog(TextConstant.youCanDeleteEmptyGroup());
    }
}
