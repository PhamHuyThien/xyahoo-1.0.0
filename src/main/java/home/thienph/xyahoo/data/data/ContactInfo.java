package home.thienph.xyahoo.data.data;

import home.thienph.xyahoo.managers.MessageHandler;

public final class ContactInfo {
    public String contactId;
    public String displayName;
    public int statusCode; //mã trạng thái (0=offline, 1=online, 2=offline...), 95%
    public String statusMessage;
    public boolean isOnline;
    public int[] permissions; //mảng quyền hạn (int[]), 85%
    public int roomId;
    public int index;
    public int additionalFlags;
    private int textColor = 0xFFFFFF;
    public Integer colorObject;

    public ContactInfo() {
    }

    public ContactInfo(String contactId, String displayName, int statusCode, String statusMessage, int[] permissions, int roomId, int index) {
        this.contactId = contactId;
        this.displayName = displayName.equals("") || displayName == null ? contactId : displayName;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.permissions = permissions;
        this.roomId = roomId;
        this.index = index;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int n) {
        this.textColor = MessageHandler.c(n);
        this.colorObject = new Integer(this.textColor);
    }
}
