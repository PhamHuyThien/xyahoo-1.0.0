package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

final class thien_ct
implements thien_ae {
    thien_ct() {
    }

    public final void a() {
        String[] stringArray = RecordStore.listRecordStores();
        if (stringArray != null) {
            try {
                int n = stringArray.length;
                while (--n >= 0) {
                    RecordStore.deleteRecordStore((String)stringArray[n]);
                }
            }
            catch (Exception exception) {}
        }
        thien_di.c.a("\u0110\u00e3 x\u00f3a d\u1eef li\u1ec7u c\u00e1 nh\u00e2n", (Image)null, 2);
    }
}
