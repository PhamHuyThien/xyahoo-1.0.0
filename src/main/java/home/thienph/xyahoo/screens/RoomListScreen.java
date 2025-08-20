package home.thienph.xyahoo.screens;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.components.ContactListUI;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.data.data.PopupSideElementData;
import home.thienph.xyahoo.managers.GameManager;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class RoomListScreen
extends Screen {
    public ContactListUI contactListUI;
    public int selectedRoomIndex;
    private Vector menuActions;
    public PopupSideElementData popupMenuData;
    public static UIAction cashInAction = new UIAction("Nạp xuxu", new CashInXuxuAction());

    public RoomListScreen() {
        this.isLocked = true;
        this.contactListUI = new ContactListUI(1, 1, Screen.e - 3, Screen.formHeight - 2 - GameManager.topMargin, 0);
        this.addControl(this.contactListUI);
        this.selectControl(this.contactListUI);
        this.rightCommand = new UIAction("Tìm phòng", new thien_eo(this));
        this.menuActions = new Vector();
        this.menuActions.addElement(new UIAction(TextConstant.update(), new UpdateRoomListAction(this)));
        this.menuActions.addElement(cashInAction);
        this.menuActions.addElement(new UIAction(TextConstant.close(), new CloseRoomListAction(this)));
        this.popupMenuData = new PopupSideElementData(this.menuActions);
        this.leftCommand = new UIAction("Menu", new OpenMenuRoomListAction(this));
    }

    public final void updateLayout() {
        this.contactListUI.handleFocus();
    }

    public final void drawOverlay(Graphics graphics) {
        this.contactListUI.drawScrollbar(graphics);
    }
}
