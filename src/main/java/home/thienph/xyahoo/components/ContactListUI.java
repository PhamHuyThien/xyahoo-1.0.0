package home.thienph.xyahoo.components;

import home.thienph.xyahoo.actions.*;
import home.thienph.xyahoo.data.data.ContactDataSource;
import home.thienph.xyahoo.data.data.ContactEntry;
import home.thienph.xyahoo.data.data.ContactGroup;
import home.thienph.xyahoo.data.data.UIAction;
import home.thienph.xyahoo.main.GameCanvas;
import home.thienph.xyahoo.constants.TextConstant;
import home.thienph.xyahoo.utils.TextRenderer;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class ContactListUI
extends UIControlBase {
    private int targetScrollY;
    private int scrollVelocity;
    private int scrollAcceleration;
    private int currentScrollY;
    private int maxScrollY;
    private int itemHeight;
    private int topVisibleIndex;
    private int visibleItemCount;
    public int selectedIndex2;
    public UIAction selectAction;
    private UIAction groupAction;
    private int displayMode; //, chế độ hiển thị (0=normal, 1=expanded)
    private ContactDataSource dataSource;
    public Vector displayItems;
    private DisplayItem selectedItem;
    public IAction itemSelectCallback;
    private int textAreaWidth;
    private int leftMargin;
    private int iconAreaWidth;
    private int expandedHeight;
    private int centerX;
    private int totalItems;
    private int itemSpacing;
    private int halfWidth;
    private boolean isDragging;
    private int lastDragX;
    private int lastDragY;

    public final void setDataSource(ContactDataSource contactDataSource2, int n) {
        this.dataSource = contactDataSource2;
        this.selectedIndex2 = 0;
        this.rebuildDisplayList();
        this.handleFocus();
    }

    public ContactListUI(int displayMode, int n2, int n3, int n4, int n5) {
        super(1, 1, n3, n4, true);
        new Vector();
        this.selectAction = new UIAction(TextConstant.select(), null);
        this.groupAction = new UIAction("", null);
        (new String[1])[0] = TextConstant.pleaseWait();
        System.currentTimeMillis();
        this.displayMode = 0;
        this.isEnabled = true;
        this.itemHeight = TextRenderer.fontHeight + 3;
        if (this.itemHeight < BuddyListControl.statusIcons[0].getHeight()) {
            this.itemHeight = BuddyListControl.statusIcons[0].getHeight();
        }
        this.textAreaWidth = n3 - 51;
        this.leftMargin = 1;
        this.iconAreaWidth = 50;
        this.expandedHeight = 120;
        this.halfWidth = n3 / 2;
    }

    private void rebuildDisplayList() {
        this.displayItems = new Vector();
        if (this.dataSource == null || this.dataSource.groups == null || this.dataSource.groups.size() == 0) {
            this.topVisibleIndex = 0;
            this.visibleItemCount = 0;
            this.maxScrollY = 0;
            return;
        }
        Vector vector = this.dataSource.groups;
        int n = vector.size();
        boolean bl = false;
        int n2 = 0;
        while (n2 < n) {
            block12: {
                Object object;
                ContactGroup contactGroup2;
                block11: {
                    contactGroup2 = (ContactGroup)vector.elementAt(n2);
                    object = new DisplayItem();
                    new DisplayItem().displayName = contactGroup2.getGroupName();
                    if (((DisplayItem)object).displayName == null || ((DisplayItem)object).displayName.length() <= 0) break block11;
                    ((DisplayItem)object).itemType = 1;
                    ((DisplayItem)object).statusCode = contactGroup2.getGroupStatus();
                    this.displayItems.addElement(object);
                    if (((DisplayItem)object).statusCode == 1) break block12;
                }
                object = contactGroup2.contacts;
                int n3 = ((Vector)object).size();
                int n4 = 0;
                while (n4 < n3) {
                    ContactEntry contactEntry2 = (ContactEntry)((Vector)object).elementAt(n4);
                    DisplayItem displayItem2 = new DisplayItem();
                    new DisplayItem().additionalData = contactEntry2.permissions;
                    displayItem2.displayName = contactEntry2.contactId;
                    displayItem2.statusCode = contactEntry2.statusCode;
                    displayItem2.statusText = contactEntry2.displayName;
                    displayItem2.textColor = contactEntry2.getTextColor();
                    displayItem2.fontRenderer = contactEntry2.colorObject;
                    displayItem2.fontRenderer = new Integer(contactEntry2.getTextColor());
                    displayItem2.isSelected = contactEntry2.isOnline;
                    displayItem2.detailText = contactEntry2.statusMessage;
                    displayItem2.sourceEntry = contactEntry2;
                    this.displayItems.addElement(displayItem2);
                    ++n4;
                }
            }
            ++n2;
        }
        if (this.selectedIndex2 < 0) {
            this.selectedIndex2 = 0;
        }
        if (this.selectedIndex2 >= this.displayItems.size()) {
            this.selectedIndex2 = this.displayItems.size() - 1;
        }
        this.visibleItemCount = this.height / this.itemHeight + 1;
        this.maxScrollY = this.displayItems.size() * this.itemHeight - this.height + 3 + this.itemHeight;
        this.targetScrollY = this.selectedIndex2 * this.itemHeight - (this.height >> 1);
        this.topVisibleIndex = this.selectedIndex2 - (this.visibleItemCount >> 1);
        if (this.displayItems.size() - this.selectedIndex2 < this.visibleItemCount >> 1) {
            this.topVisibleIndex = this.displayItems.size() - this.visibleItemCount;
        }
        if (this.topVisibleIndex < 0) {
            this.topVisibleIndex = 0;
        }
        if (((DisplayItem)this.displayItems.elementAt((int)this.selectedIndex2)).itemType == 1) {
            this.actionTertiary = this.groupAction;
            return;
        }
        this.actionTertiary = this.selectAction;
    }

    public final boolean handleSoftKey(int n) {
        if (n == 13 || n == 12) {
            this.handleKeyInput(n);
            return false;
        }
        return true;
    }

    public final boolean handleKeyInput(int n) {
        if (this.displayItems == null || this.displayItems.size() == 0) {
            return true;
        }
        if (n == 12) {
            System.currentTimeMillis();
            --this.selectedIndex2;
            if (this.selectedIndex2 < 0) {
                this.selectedIndex2 = this.displayItems.size() - 1;
            }
        }
        if (n == 13) {
            System.currentTimeMillis();
            ++this.selectedIndex2;
            if (this.selectedIndex2 >= this.displayItems.size()) {
                this.selectedIndex2 = 0;
            }
        }
        if (n == 12 || n == 13) {
            this.actionTertiary = ((DisplayItem)this.displayItems.elementAt((int)this.selectedIndex2)).itemType == 1 ? this.groupAction : this.selectAction;
            this.targetScrollY = this.selectedIndex2 * this.itemHeight - (this.height >> 1);
            this.topVisibleIndex = this.selectedIndex2 - (this.visibleItemCount >> 1);
            if (this.displayItems.size() - this.selectedIndex2 < this.visibleItemCount >> 1) {
                this.topVisibleIndex = this.displayItems.size() - this.visibleItemCount;
            }
            if (this.topVisibleIndex < 0) {
                this.topVisibleIndex = 0;
            }
            GameCanvas.resetKeys();
            if (thien_ar.a) {
                thien_ar.a(true);
            }
        }
        if (n == 16) {
            this.executeSelectedAction();
            GameCanvas.resetKeys();
        }
        return true;
    }

    private void executeSelectedAction() {
        if (this.selectedIndex2 == -1) {
            return;
        }
        this.selectedItem = (DisplayItem)this.displayItems.elementAt(this.selectedIndex2);
        if (this.selectedItem.itemType == 0) {
            if (this.itemSelectCallback != null) {
                this.itemSelectCallback.action();
                return;
            }
        } else {
            if (this.selectedItem.statusCode == 0) {
                this.dataSource.setGroupStatus(this.selectedItem.displayName, 1);
            } else {
                this.dataSource.setGroupStatus(this.selectedItem.displayName, 0);
            }
            this.rebuildDisplayList();
        }
    }

    public final void draw(Graphics graphics) {
        this.centerX = this.width >> 1;
        graphics.setClip(this.baseX, this.baseY, this.width + 1, this.height);
        graphics.translate(2, 2);
        graphics.translate(0, -this.currentScrollY);
        int n = this.topVisibleIndex * this.itemHeight;
        this.centerX = this.topVisibleIndex + this.visibleItemCount;
        this.totalItems = this.displayItems.size();
        this.itemSpacing = this.itemHeight + 2;
        int n2 = 0;
        int n3 = this.width - 3;
        int n4 = this.topVisibleIndex;
        while (n4 <= this.centerX) {
            String string;
            int n5;
            if (n4 >= this.totalItems) break;
            DisplayItem displayItem2 = (DisplayItem)this.displayItems.elementAt(n4);
            n2 = this.itemHeight;
            if (n4 == this.selectedIndex2) {
                if (this.displayMode == 1 && displayItem2.itemType == 0 && !displayItem2.statusText.equals("")) {
                    n2 <<= 1;
                }
                graphics.setColor(2580);
                graphics.fillRect(1, n + 1, n3, n2);
                graphics.setColor(9478569);
                graphics.drawRoundRect(0, n + 1, n3 + 1, n2, 5, 5);
                if (n2 > this.itemHeight && displayItem2.detailText != null) {
                    graphics.setColor(3981823);
                    TextRenderer.getFontRenderer(TextRenderer.colorHighlight).drawText(displayItem2.detailText, 22, n + this.itemSpacing, graphics);
                }
            }
            graphics.setColor(0);
            if (displayItem2.itemType == 1) {
                n5 = 18;
                graphics.drawImage(BuddyListControl.groupIcons[displayItem2.statusCode], 9, n + (this.itemHeight >> 1) + 1, 3);
            } else {
                n5 = 22;
                graphics.drawImage(BuddyListControl.statusIcons[displayItem2.statusCode], 11, n + (this.itemHeight >> 1) + 2, 3);
            }
            if (displayItem2.itemType == 1) {
                string = displayItem2.displayName;
                string = TextRenderer.wrapText(string, this.width - 26, TextRenderer.charWidth);
                graphics.setColor(16726823);
                TextRenderer.getFontRenderer(TextRenderer.colorPrimary).drawText(string, n5, n + 2, graphics);
            } else {
                string = displayItem2.statusText;
                if (string != null) {
                    string = TextRenderer.wrapText(string, this.width - 26, TextRenderer.charWidth);
                    graphics.setColor(displayItem2.textColor);
                    TextRenderer.getFontRenderer(displayItem2.fontRenderer).drawText(string, n5, n + 3, graphics);
                }
            }
            n += n2;
            ++n4;
        }
        graphics.translate(0, this.currentScrollY);
        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
        graphics.setClip(-1000, -1000, 2000, 2000);
    }

    public final void drawBackground(Graphics graphics) {
    }

    public final void update() {
        ContactListUI contactListUI2 = this;
        if (contactListUI2.currentScrollY != contactListUI2.targetScrollY) {
            contactListUI2.scrollVelocity = contactListUI2.targetScrollY - contactListUI2.currentScrollY << 2;
            contactListUI2.scrollAcceleration += contactListUI2.scrollVelocity;
            contactListUI2.currentScrollY += contactListUI2.scrollAcceleration >> 4;
            contactListUI2.scrollAcceleration &= 0xF;
            if (contactListUI2.currentScrollY > contactListUI2.maxScrollY) {
                contactListUI2.currentScrollY = contactListUI2.maxScrollY;
            }
            if (contactListUI2.currentScrollY < 0) {
                contactListUI2.currentScrollY = 0;
            }
            contactListUI2.topVisibleIndex = contactListUI2.currentScrollY / contactListUI2.itemHeight - 1;
            if (contactListUI2.topVisibleIndex < 0) {
                contactListUI2.topVisibleIndex = 0;
            }
        }
    }

    public final void handleFocus() {
        if (this.displayItems == null) {
            return;
        }
        if (this.baseY + this.displayItems.size() * this.itemHeight >= this.height) {
            thien_ar.a = true;
            thien_ar.a(this.displayItems.size());
            return;
        }
        thien_ar.a = false;
    }

    public final void drawScrollbar(Graphics graphics) {
        if (thien_ar.a) {
            thien_ar.a(graphics, this.selectedIndex2);
        }
    }

    public final void onDrag(int n, int n2) {
        this.lastDragX = n;
        this.lastDragY = n2;
    }

    public final void handleKeyPress(int n, int n2) {
        if (this.isDragging) {
            this.isDragging = false;
            this.targetScrollY -= (n2 - this.lastDragY) * 5;
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
        } else {
            n = (n2 + this.currentScrollY) / this.itemHeight;
            if (n < 0) {
                n = 0;
            }
            if (n > this.displayItems.size() - 1) {
                n = this.displayItems.size() - 1;
            }
            if (n < 0) {
                return;
            }
            if (this.selectedIndex2 == n) {
                this.executeSelectedAction();
                return;
            }
            if (this.selectedIndex2 > n) {
                this.selectedIndex2 = n;
            } else if (this.displayMode == 0) {
                this.selectedIndex2 = n;
            } else {
                DisplayItem displayItem2 = (DisplayItem)this.displayItems.elementAt(this.selectedIndex2);
                if (displayItem2.statusText == null || displayItem2.statusText.equals("")) {
                    this.selectedIndex2 = n;
                } else {
                    if (this.selectedIndex2 == n - 1) {
                        this.executeSelectedAction();
                        return;
                    }
                    this.selectedIndex2 = n - 1;
                }
            }
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void handlePointerRelease(int n, int n2) {
        if (BuddyListControl.absoluteValue(n - this.lastDragX) > 1 || BuddyListControl.absoluteValue(n2 - this.lastDragY) > 1) {
            this.isDragging = true;
            this.targetScrollY -= n2 - this.lastDragY;
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
            this.currentScrollY = this.targetScrollY;
            this.topVisibleIndex = this.currentScrollY / this.itemHeight - 1;
            if (this.topVisibleIndex < 0) {
                this.topVisibleIndex = 0;
            }
            this.lastDragX = n;
            this.lastDragY = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }
}
