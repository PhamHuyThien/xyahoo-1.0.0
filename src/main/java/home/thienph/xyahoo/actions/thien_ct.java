package home.thienph.xyahoo.actions;

import home.thienph.xyahoo.managers.GameManager;

import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class thien_ct implements IAction {
    public thien_ct() {
    }

    public final void action() {
        String[] stringArray = RecordStore.listRecordStores();
        if (stringArray != null) {
            try {
                int n = stringArray.length;
                while (--n >= 0) {
                    RecordStore.deleteRecordStore((String) stringArray[n]);
                }
            } catch (Exception exception) {
            }
        }
        GameManager.instance.showNotification("Đã xóa dữ liệu cá nhân", (Image) null, 2);
    }
}
