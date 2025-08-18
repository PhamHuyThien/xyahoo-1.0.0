package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ca extends thien_ap {
   public static thien_ca D;
   private Vector J;
   thien_am E;
   thien_at F = null;
   boolean G;
   public thien_af H;
   static thien_ab I = new thien_ab(thien_as.M(), new thien_cb());

   private void f() {
      String[] var1;
      int var2 = (var1 = new String[]{"Yahoo!", "Tiến Lên", "Games", "Tài Khoản"}).length;

      try {
         Image[] var3 = new Image[var2];

         for (byte var4 = 0; var4 < var2; var4++) {
            var3[var4] = Image.createImage("/Icn" + var4 + ".png");
         }

         this.H = new thien_af(
            0, thien_an.d + 7, thien_an.e - 3, thien_an.f - 3 - thien_di.g, var2, var1, null, null, var3[0].getWidth(), var3[0].getHeight(), true, 1
         );
         thien_af var6 = this.H;
         this.H.a = var3;
         System.gc();
      } catch (IOException var5) {
      }

      this.a(this.H);
      this.c(this.H);
      thien_af var10000 = this.H;
      thien_ab var7 = new thien_ab(thien_as.P(), new thien_cc(this));
      var10000.y = var7;
   }

   public thien_ca() {
      super.g = "X Yahoo!";
      D = this;
      thien_ab var1 = new thien_ab(thien_as.L(), new thien_cd(this));
      thien_ab var2 = new thien_ab(thien_as.e(), new thien_ce(this));
      thien_ab var3 = new thien_ab(thien_as.C(), new thien_ch(this));
      Vector var4;
      (var4 = new Vector()).addElement(I);
      var4.addElement(var2);
      var4.addElement(thien_cq.H);
      (var2 = new thien_ab(thien_as.c(), null)).c = new thien_am(var4);
      this.J = new Vector();
      this.J.addElement(var2);
      this.J.addElement(var1);
      this.J.addElement(var3);
      this.E = new thien_am(this.J);
      super.k = new thien_ab("Menu", new thien_cj(this));
      this.f();
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (this.G) {
         if (var1[12]) {
            var1[12] = false;
         } else if (var1[13]) {
            var1[13] = false;
         }
      }

      return super.a(var1, var2, var3);
   }

   public static void f(int var0, int var1) {
      thien_an var2;
      if ((var2 = thien_di.c.d(var0)) != null) {
         thien_di.c.c();
         var2.a(1);
         thien_di.c.d(var2);
      } else {
         MessageHandler.a(var1);
      }
   }

   public final void e(int var1) {
      thien_di var2 = thien_di.c;
      System.gc();
      switch (var1) {
         case 0:
            var2.y();
            return;
         case 1:
            if (thien_di.a) {
               var2.x();
               return;
            }

            MessageHandler.a(5009);
            return;
         case 2:
            f(8888193, 5029);
         default:
            return;
         case 3:
            f(5000, 5018);
      }
   }

   public final void a(Graphics var1) {
      super.a(var1);
   }

   public final void d() {
      this.H.f();
   }

   public final void d(Graphics var1) {
      this.H.c(var1);
   }

   static void a(thien_ca var0) {
      var0.b(var0.F);
      var0.c(var0.H);
      var0.F.a("");
      var0.G = false;
   }
}
