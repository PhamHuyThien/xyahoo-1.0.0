package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.data.data.ContactEntry;

public final class DisplayItem {
    public int itemType;
    public int textColor;
    public Integer fontRenderer;
    public String displayName;
    public String statusText;
    public String detailText;
    public int statusCode; // mã trạng thái (online/offline/busy...), 90%
    public boolean isSelected;
    public ContactEntry sourceEntry;
    public int[] additionalData;
}
