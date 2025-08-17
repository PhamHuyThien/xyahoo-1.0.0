package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_cn extends thien_an {
   private thien_b y = thien_di.b().j.x;
   String w;
   String x;
   private boolean z;
   private final thien_at A = new thien_at();

   public final String[] e() {
      Vector var1 = new Vector();
      Vector var2 = this.y.l;

      for (int var3 = 0; var3 < var2.size(); var3++) {
         thien_u var4;
         if ((var4 = (thien_u)var2.elementAt(var3)).a == 0 && var4.h) {
            var4.h = false;
            var1.addElement(var4.d);
         }
      }

      String[] var5 = new String[var1.size()];

      for (int var6 = 0; var6 < var5.length; var6++) {
         var5[var6] = (String)var1.elementAt(var6);
      }

      return var5;
   }

   public thien_cn() {
      this.A.a = true;
      this.A.a(0, thien_an.f - thien_di.g - thien_w.f - 11, thien_an.e - 6, thien_w.f + 6);
      super.g = thien_as.ak();
      this.a(this.y);
      this.c(this.y);
      super.l = new thien_ab("OK", new thien_co(this));
      super.k = new thien_ab(thien_as.z(), new thien_cp(this));
   }

   public final void f() {
      if (this.y.l != null) {
         this.y.l.removeAllElements();
      }

      this.y.l = null;
      this.y.k = null;
   }

   public final void d() {
      this.y.f();
   }

   public final void d(Graphics var1) {
      this.y.c(var1);
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.z) {
         this.A.a("");
         this.a(this.A);
         this.c(this.A);
         this.z = true;
      }

      String var4 = "";
      if (this.z) {
         if (var1[12]) {
            var1[12] = false;
            this.y.b(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.y.b(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.y.b(16);
         }

         var4 = this.A.c();
      }

      super.a(var1, var2, var3);
      if (this.z) {
         if (this.A.c().equals("")) {
            this.c(this.y);
            this.b(this.A);
            this.z = false;
         }

         if (!this.A.c().equals(var4)) {
            this.y.d(this.A.c());
         }
      }

      return true;
   }
}
