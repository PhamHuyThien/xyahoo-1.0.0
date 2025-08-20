package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.components.UIDropdown;
import home.thienph.xyahoo.main.Xuka;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.Screen;
import home.thienph.xyahoo.utils.ContentFilter;

public final class thien_fn
implements IAction {
    private final TextField textField;
    private final UIDropdown uiDropdown;
    private final Screen screen;

    public thien_fn(BuddyListScreen buddyListScreen2, TextField textField2, UIDropdown UIDropdown2, Screen screen2) {
        this.textField = textField2;
        this.uiDropdown = UIDropdown2;
        this.screen = screen2;
    }

    public final void action() {
        String string = ContentFilter.filterProfanity(this.textField.getText().trim());
        int n = this.uiDropdown.a() == 0 ? 1 : 0;
        if (n != BuddyListScreen.userStatus) {
            MessageHandler.a(n, 1);
            BuddyListScreen.userStatus = n;
        }
        if (BuddyListScreen.userStatus == 1) {
            MessageHandler.a(string, 1);
            BuddyListScreen.tempStatusMessage = string;
            Xuka.saveCustomStr(BuddyListScreen.currentGroupName, BuddyListScreen.tempStatusMessage, false);
        }
        GameManager.getInstance().removeScreen(this.screen);
        GameManager.instance.focusBuddyList();
    }
}
