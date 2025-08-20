package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.ContactListUI;
import home.thienph.xyahoo.components.UIAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class RoomListScreen
extends Screen {
    public ContactListUI contactListUI;
    public int x;
    private Vector A;
    public PopupSideElementData y;
    public static UIAction z = new UIAction("Nạp xuxu", new thien_en());

    public RoomListScreen() {
        this.isLocked = true;
        this.contactListUI = new ContactListUI(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.topMargin, 0);
        this.addControl(this.contactListUI);
        this.selectControl(this.contactListUI);
        this.rightCommand = new UIAction("Tìm phòng", new thien_eo(this));
        this.A = new Vector();
        this.A.addElement(new UIAction(TextConstant.update(), new thien_ep(this)));
        this.A.addElement(z);
        this.A.addElement(new UIAction(TextConstant.close(), new thien_eq(this)));
        this.y = new PopupSideElementData(this.A);
        this.leftCommand = new UIAction("Menu", new thien_er(this));
    }

    public final void updateLayout() {
        this.contactListUI.handleFocus();
    }

    public final void drawOverlay(Graphics graphics) {
        this.contactListUI.drawScrollbar(graphics);
    }
}
