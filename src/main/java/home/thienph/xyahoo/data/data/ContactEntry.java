package home.thienph.xyahoo.data.data;

import home.thienph.xyahoo.managers.MessageHandler;

public final class ContactEntry {
    public String contactId;
    public String displayName;
    public int statusCode; //mã trạng thái (0=offline, 1=online, 2=busy...), 95%
    public String statusMessage;
    public boolean isOnline;
    public int[] permissions; //mảng quyền hạn (int[]), 85%
    public int roomId;
    public int userLevel;
    public int additionalFlags;
    private int textColor = 0xFFFFFF;
    public Integer colorObject;

    public ContactEntry() {
    }

    public ContactEntry(String string, String string2, int n, String string3, int[] nArray, int n2, int n3) {
        this.contactId = string;
        this.displayName = string2.equals("") || string2 == null ? string : string2;
        this.statusCode = n;
        this.statusMessage = string3;
        this.permissions = nArray;
        this.roomId = n2;
        this.userLevel = n3;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int n) {
        this.textColor = MessageHandler.c(n);
        this.colorObject = new Integer(this.textColor);
    }
}
