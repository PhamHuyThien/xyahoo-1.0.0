package home.thienph.xyahoo;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class thien_d extends Canvas implements Runnable {
   public static thien_d a;
   static boolean b;
   private static boolean[] n = new boolean[21];
   private static boolean[] o = new boolean[21];
   private static int[] p = new int[1];
   static boolean c;
   static boolean d;
   static boolean e;
   static boolean f;
   public static int g;
   public static int h;
   public static int i;
   public static int j;
   public static int k;
   public static boolean l;
   private static int q;
   public static boolean m = false;

   static {
      new Object();
   }

   public thien_d() {
      System.gc();
      this.setFullScreenMode(true);
      a = this;
      l = this.getKeyCode(8) == -20;
      j = this.getWidth();
      k = this.getHeight();
      i = 0;
      thien_w.a();
      thien_es var1 = thien_es.a();
      thien_hc.a(1, var1);
      thien_hc.a(1001, var1);
      thien_hc.a(1000, var1);
      thien_hc.a(39, var1);
      thien_hc.a(2, thien_eu.a());
      thien_hc.a(48, var1);
      thien_hc.a(1001, var1);
      thien_hc.b = var1;
      thien_di var2;
      thien_es.a(var2 = thien_di.b());
      thien_eu.a(var2);
      thien_hc.a(new thien_hb(-2, -1));
      new Thread(this).start();
   }

   public final void a() {
      if (!thien_hc.c && !thien_hc.d) {
         Xuka.h();
         Xuka.i();
         String[] var1 = Xuka.c;
         int[] var2 = Xuka.a;
         int var3 = (int)(System.currentTimeMillis() % (long)var1.length);
         int var4 = (int)(System.currentTimeMillis() % (long)Xuka.c.length);
         thien_hc.a(var1[var3], Xuka.c[var4], var2[var3], Xuka.a[var4]);
      }
   }

   public final void run() {
      b = true;

      while (b) {
         long var1 = System.currentTimeMillis();

         try {
            switch (i) {
               case 0:
                  j = a.getWidth();
                  k = a.getHeight();
                  if (thien_ev.a == 35) {
                     thien_di.b().a(j, k);
                  }

                  if (m) {
                     System.gc();
                     i = 1;
                  }

                  thien_ev.a++;
                  break;
               case 1:
                  thien_di.c.a(n, o, p);
            }
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.repaint();
         this.serviceRepaints();
         long var6;
         var1 = (var6 = System.currentTimeMillis() - var1) < 35L ? 35L - var6 : 1L;

         try {
            Thread.sleep(var1);
         } catch (Exception var4) {
         }
      }

      Xuka.g.destroyApp(false);
      Xuka.g.notifyDestroyed();
   }

   protected final void keyPressed(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         p[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            n[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            n[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            n[17] = true;
            return;
         case -39:
         case -2:
            n[13] = true;
            return;
         case -38:
         case -1:
            n[12] = true;
            return;
         case -11:
            n[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            n[16] = true;
            return;
         case -4:
            n[15] = true;
            return;
         case -3:
            n[14] = true;
            return;
         case 35:
            n[11] = true;
            return;
         case 42:
            n[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            n[var1 - 48] = true;
            return;
      }
   }

   protected final void keyRepeated(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         p[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            o[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            o[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            o[17] = true;
            return;
         case -39:
         case -2:
            o[13] = true;
            return;
         case -38:
         case -1:
            o[12] = true;
            return;
         case -11:
            o[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            o[16] = true;
            return;
         case -4:
            o[15] = true;
            return;
         case -3:
            o[14] = true;
            return;
         case 35:
            o[11] = true;
            return;
         case 42:
            o[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            o[var1 - 48] = true;
            return;
      }
   }

   protected final void keyReleased(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
               var1 = -7;
               break;
            case -21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      switch (var1) {
         case -39:
         case -2:
            o[13] = false;
            return;
         case -38:
         case -1:
            o[12] = false;
            return;
         case -22:
         case -7:
            o[18] = false;
            return;
         case -21:
         case -6:
            o[17] = false;
            return;
         case -11:
            o[20] = false;
            return;
         case -8:
         case 8:
            o[19] = false;
            return;
         case -5:
         case 10:
         case 13:
            o[16] = false;
            return;
         case -4:
            o[15] = false;
            return;
         case -3:
            o[14] = false;
            return;
         case 35:
            o[11] = false;
            return;
         case 42:
            o[10] = false;
            return;
         case 48:
         case 49:
            q++;
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            o[var1 - 48] = false;
            return;
      }
   }

   public static void b() {
      for (int var0 = 0; var0 < 21; var0++) {
         n[var0] = false;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      c = true;
      f = true;
      g = var1;
      h = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      c = true;
      e = true;
      g = var1;
      h = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      c = false;
      d = true;
      g = var1;
      h = var2;
   }

   protected final void paint(Graphics var1) {
      try {
         switch (i) {
            case 0:
               var1.setColor(1055519);
               var1.fillRect(0, 0, j, k);
               if (!m) {
                  var1.drawImage(thien_aq.c(), j >> 1, (k >> 1) - 15, 3);
                  var1.setColor(16777215);
                  thien_di.c.a(var1, j >> 1, (k + thien_aq.a >> 1) + 3);
                  thien_w.a(thien_w.d).a(thien_di.b, j - 8, k - thien_w.f - 8, 1, var1, thien_w.j, thien_w.f);
                  thien_di.c.h++;
               }
            default:
               return;
            case 1:
               thien_di.c.a(var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
