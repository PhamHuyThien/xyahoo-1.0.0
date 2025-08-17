package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class thien_ck {
   private static Hashtable a = new Hashtable();

   public static Image a(int var0) {
      Image var1;
      if ((var1 = (Image)a.get(new Integer(var0))) != null) {
         return var1;
      } else {
         if ((var1 = b(var0)) != null) {
            a.put(new Integer(var0), var1);
         } else {
            thien_a.b(var0);
            var1 = thien_b.a[2];
            a.put(new Integer(var0), var1);
         }

         return var1;
      }
   }

   public static void a(int var0, byte[] var1) {
      try {
         try {
            a.remove(new Integer(var0));
         } catch (Exception var3) {
         }

         a.put(new Integer(var0), Image.createImage(var1, 0, var1.length));
         String var10000 = "img" + var0;
         var1 = var1;
         String var5 = var10000;

         try {
            RecordStore var6;
            if ((var6 = RecordStore.openRecordStore(var5, true)).getNumRecords() > 0) {
               var6.setRecord(1, var1, 0, var1.length);
            } else {
               var6.addRecord(var1, 0, var1.length);
            }

            var6.closeRecordStore();
         } catch (Exception var2) {
            var2.printStackTrace();
            return;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private static Image b(int var0) {
      Image var1 = null;

      try {
         var1 = Image.createImage("/" + var0 + ".png");
      } catch (IOException var3) {
      }

      if (var1 != null) {
         return var1;
      } else {
         byte[] var4 = a("img" + var0);

         try {
            var1 = Image.createImage(var4, 0, var4.length);
         } catch (Exception var2) {
         }

         return var1;
      }
   }

   private static byte[] a(String var0) {
      try {
         RecordStore var3;
         byte[] var1 = (var3 = RecordStore.openRecordStore(var0, false)).getRecord(1);
         var3.closeRecordStore();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }
}
