package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.data.ContactGroup;
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
        DisplayItem displayItem2;
        block6: {
            displayItem2 = this.buddyListScreen.buddyList.getSelectedItem();
            if (displayItem2 == null) {
                return;
            }
            if (displayItem2.itemType == 0) {
                if (displayItem2.statusCode == 3) {
                    return;
                }
                this.buddyListScreen.buddyList.getCurrentGroupName();
                MessageHandler.f(displayItem2.displayName);
                return;
            }
            String string = displayItem2.displayName;
            ContactDataSource contactDataSource2 = this.buddyListScreen.buddyList.getDataModel();
            int n = contactDataSource2.groups.size() - 1;
            while (n >= 0) {
                ContactGroup contactGroup2 = (ContactGroup) contactDataSource2.groups.elementAt(n);
                if (contactGroup2.getGroupName().equals(string)) {
                    bl = contactGroup2.contacts.size() == 0;
                    break block6;
                }
                --n;
            }
            bl = false;
        }
        if (bl) {
            MessageHandler.e(displayItem2.displayName);
            GameManager.getInstance().buddyListScreen.buddyList.removeEmptyGroup(displayItem2.displayName);
            return;
        }
        GameManager.getInstance().showSimpleDialog(TextConstant.youCanDeleteEmptyGroup());
    }
}
