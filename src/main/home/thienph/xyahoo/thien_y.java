package home.thienph.xyahoo;

import javax.microedition.lcdui.Image;

public class thien_y implements thien_ae {
   private final thien_ae a;

   thien_y(thien_x var1, thien_ae var2) {
      this.a = var2;
   }

   public final void a() {
      if (this.a != null) {
         this.a.a();
      }
   }

   public static thien_at a(thien_ap var0, String var1, int var2) {
      return b(var0, var1, 0, -1);
   }

   public static thien_at a(thien_ap var0, String var1, int var2, int var3) {
      thien_ai var4;
      (var4 = new thien_ai(var1, thien_ap.z, var0.x, thien_w.f, -1)).s = thien_ap.B;
      var0.a(var4, false);
      thien_at var5;
      (var5 = new thien_at()).z = -1;
      var5.a(thien_ap.A, var0.x, thien_ap.C, thien_w.f + 6);
      var5.e(var2);
      var0.a(var5, true);
      return var5;
   }

   public static thien_at b(thien_ap var0, String var1, int var2, int var3) {
      var0.a(new thien_ai(var1, var0.w, var0.x, thien_w.f, var3));
      var0.x += 2;
      thien_at var4;
      (var4 = new thien_at()).z = var3;
      var4.a(var0.w, var0.x, var0.y, thien_w.f + 6);
      var4.e(var2);
      var0.a(var4);
      return var4;
   }

   public static thien_z a(thien_ap var0, String var1, String[] var2) {
      return a(var0, var1, var2, -1);
   }

   public static thien_z a(thien_ap var0, String var1, String[] var2, int var3) {
      var0.a(new thien_ai(var1, var0.w, var0.x, thien_w.f, var3));
      var0.x += 2;
      thien_z var4;
      (var4 = new thien_z(var2, var0.w, var0.x, var0.y, thien_w.f + 6)).z = var3;
      var0.a(var4);
      return var4;
   }

   public static thien_ai a(thien_ap var0, int var1) {
      thien_ai var2;
      (var2 = new thien_ai("", 5, var0.x, 10)).z = var1;
      var0.a(var2);
      return var2;
   }

   public static thien_ai[] a(String var0, thien_ap var1, int var2, int var3, boolean var4, boolean var5) {
      String[] var6;
      thien_ai[] var7 = new thien_ai[(var6 = thien_w.b(var0, thien_an.e - (var5 ? 10 : var1.w + 10), thien_w.j)).length];

      for (int var8 = 0; var8 < var6.length; var8++) {
         var7[var8] = new thien_ai(var6[var8], var5 ? 5 : var1.w, var1.x, thien_w.f + 2);
         var7[var8].z = var2;
         var7[var8].o = true;
         var7[var8].a = var3;
         var7[var8].b = new Integer(var3);
         var7[var8].o = var4 && !var0.trim().equals("");
         var1.a(var7[var8]);
      }

      return var7;
   }

   public static thien_v a(thien_ap var0, String var1, int var2, thien_ae var3, int var4, int var5, int var6) {
      var2 = thien_w.a(var1, thien_w.j) + 20;
      if (var2 > 0) {
         var6 = var2;
      }

      thien_v var7;
      (var7 = new thien_v(var1, var4, var5, var6, thien_w.f + 6)).z = 0;
      var7.a = var3;
      var7.y.b = var3;
      if (var0 != null) {
         var0.a(var7);
      }

      return var7;
   }

   public static thien_aj b(thien_ap var0, String var1, int var2, thien_ae var3, int var4, int var5, int var6) {
      int var7;
      if ((var7 = thien_w.a(var1, thien_w.j)) < var6) {
         var6 = var7;
      }

      thien_aj var8;
      (var8 = new thien_aj(var1, var4, var5, var6, thien_w.f + 4)).z = var2;
      var8.b = var3;
      var8.y.b = new thien_ak(var8);
      if (var0 != null) {
         var0.a(var8);
      }

      return var8;
   }

   public static thien_x a(thien_ap var0, String var1, thien_ae var2) {
      int var5 = thien_w.a(var1, thien_w.j) + 13 + 4;
      thien_x var4;
      thien_x var10000 = var4 = new thien_x(var1, var0.w, var0.x, var5, thien_w.f + 4);
      Object var3 = null;
      thien_x var6 = var10000;
      var10000.b = (thien_ae)var3;
      var6.x.b = new thien_y(var6, (thien_ae)var3);
      if (var0 != null) {
         var0.a(var4);
      }

      return var4;
   }

   public static thien_ai[] a(thien_ap var0, String var1) {
      return a(var1, var0, -1, 16777215, true, true);
   }

   public static thien_ag a(thien_ap var0, byte[] var1, int var2) {
      Image var3 = Image.createImage(var1, 0, var1.length);
      thien_ag var4;
      (var4 = new thien_ag()).a = var1;
      var4.a(thien_an.e - var3.getWidth() >> 1, var0.x, var3.getWidth(), var3.getHeight());
      var4.d(var3.getWidth(), var3.getHeight());
      var4.o = true;
      var4.a(var3);
      var4.z = var2;
      var0.a(var4);
      return var4;
   }

   public static thien_ag a(thien_ap var0, int[] var1, int var2, int var3, int var4) {
      thien_ag var5;
      (var5 = new thien_ag()).a(thien_an.e - var2 >> 1, var0.x, var2, var3);
      var5.d(var2, var3);
      var5.o = true;
      var5.a(var1);
      var5.z = var4;
      var0.a(var5);
      return var5;
   }

   public static thien_ag a(thien_ap var0, Image var1, boolean var2) {
      thien_ag var3;
      (var3 = new thien_ag()).a(thien_an.e - var1.getWidth() >> 1, var0.x, var1.getWidth(), var1.getHeight());
      var3.d(var1.getWidth(), var1.getHeight());
      var3.o = false;
      var3.a(var1);
      var0.a(var3);
      return var3;
   }
}
