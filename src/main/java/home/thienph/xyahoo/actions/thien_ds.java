package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.components.TextField;
import home.thienph.xyahoo.data.data.ContactInfo;
import home.thienph.xyahoo.managers.GameManager;
import home.thienph.xyahoo.managers.MessageHandler;
import home.thienph.xyahoo.screens.BuddyListScreen;
import home.thienph.xyahoo.screens.FormScreen;

public final class thien_ds implements IAction {
    private GameManager gameManager;
    private final TextField textField;
    private final String c;
    private final FormScreen formScreen;

    public thien_ds(GameManager gameManager2, TextField textField2, String string, FormScreen formScreen2) {
        this.gameManager = gameManager2;
        this.textField = textField2;
        this.c = string;
        this.formScreen = formScreen2;
    }

    public final void action() {
        if (this.textField.getText().equals("")) {
            return;
        }
        this.gameManager.buddyListScreen.buddyList.getDataModel().addContactToGroup(this.textField.getText(), new ContactInfo(this.c, "", 0, "", new int[0], 0, 0));
        this.gameManager.buddyListScreen.buddyList.rebuildVisibleItems();
        BuddyListScreen buddyListScreen2 = this.gameManager.buddyListScreen;
        buddyListScreen2.buddyList.cleanup();
        MessageHandler.a(true, this.textField.getText(), this.c);
        this.gameManager.removeScreen(this.formScreen);
    }
}
