package home.thienph.xyahoo;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class thien_hf implements Runnable {
   private final String a;
   private final String b;
   private final int c;
   private final int d;

   thien_hf(String var1, String var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void run() {
      thien_hc.d = true;
      thien_hc.c = true;

      try {
         a(this.a, this.c);
      } catch (Exception var4) {
         try {
            a(this.b, this.d);
         } catch (Exception var3) {
            thien_hc.c = false;

            try {
               if (thien_hc.b != null) {
                  thien_hc.b();
                  thien_hc.b.b();
                  return;
               }
            } catch (Exception var2) {
               var3.printStackTrace();
            }
         }
      }
   }

   private static void a(String var0, int var1) throws IOException {
      System.out.println("Connecting to " + var0);

      try {
         thien_hc.a((SocketConnection)Connector.open("socket://" + var0 + ":" + var1));
      } catch (Exception var3) {
         System.out.println("sc " + var3.toString());
         throw new IOException();
      }

      try {
         thien_hc.c().setSocketOption((byte)2, 1);
      } catch (Exception var2) {
         System.out.println("kp " + var2.toString());
      }

      thien_hc.a(thien_hc.c().openDataOutputStream());
      thien_hc.a = thien_hc.c().openInputStream();
      (thien_hc.f = new Thread(thien_hc.d())).start();
      (thien_hc.e = new Thread(new thien_hd())).start();
      thien_hc.d = false;
      thien_hc.b.d();
      System.out.println("Connected!");
   }
}
