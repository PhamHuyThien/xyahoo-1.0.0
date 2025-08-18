package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class thien_ew extends thien_an {
   public boolean w;
   public String x;
   public String y;
   private String B;
   public thien_e z;
   thien_at A;
   private boolean C;
   private final thien_am D;
   private final Vector E;

   public thien_ew(String var1, boolean var2, boolean var3, int[] var4) {
      super.p = true;
      this.w = var2;
      this.C = var3;
      super.g = var1;
      this.A = new thien_at();
      this.A.b = false;
      this.A.a(1, thien_an.f - thien_di.g - 2, thien_an.e - 3, thien_w.f + 6);
      this.z = new thien_e(1, 1, thien_an.e - 3, thien_an.f - thien_di.g - thien_w.f - 7);
      this.a(this.z);
      this.a(this.A);
      this.c(this.A);
      this.E = new Vector();
      this.E.addElement(new thien_ab(TextConstant.smileys(), new thien_ex(this)));
      this.E.addElement(new thien_ab(TextConstant.buzz(), new thien_ey(this, var2)));
      if (var3) {
         this.E.addElement(new thien_ab(TextConstant.invite(), new thien_ez(this)));
      }

      this.E.addElement(new thien_ab("Copy", new thien_fa(this)));
      this.E.addElement(new thien_ab(TextConstant.paste(), new thien_fb(this)));
      this.E.addElement(new thien_ab(TextConstant.close(), new thien_fc(this, var3)));
      this.D = new thien_am(this.E);
      super.k = new thien_ab("Menu", new thien_fd(this));
      super.m = new thien_ab("Chat", null);
      if (thien_di.E != null) {
         this.z.a(thien_di.E, 2);
      }
   }

   public static void e() {
      if (thien_ff.E != null) {
         thien_aq.a(thien_ff.E, 1);
      }
   }

   public final void b(String var1) {
      this.B = var1;
      if (this.B != null) {
         thien_aq.a(this.B, 1);
      }

      if (thien_ff.E != null) {
         thien_aq.a(thien_ff.E, 1);
      }
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.A.a(thien_fe.b(this.A.c()));
         if (this.A.c().equals("")) {
            String var8;
            int var10;
            if ((var10 = (var8 = this.z.c()).indexOf("http://")) >= 0) {
               String var9 = var8.substring(var10);

               try {
                  Xuka.instance.platformRequest(var9);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.A.a();
               return false;
            }
         } else {
            if (this.A.c().equals("plf")) {
               this.z.a("", Xuka.platformName, 0);
            }

            Object var5 = null;
            if (this.C) {
               thien_di.c.B = thien_ff.y;
               thien_di.c.C++;
               if (thien_di.c.C > 5) {
                  this.z.a("Bạn chỉ có thể chat 5 câu liên tục khi chat nhóm", 1);
                  return false;
               }

               MessageHandler.f(super.h, this.A.c());
            } else if (this.w) {
               MessageHandler.a((String)(var5 = thien_gp.x), this.x, this.A.c(), 2);
            } else {
               MessageHandler.a((String)(var5 = thien_ff.y), super.g, this.A.c(), 1);
            }

            this.z.a(this.w ? thien_gp.y : thien_ff.A, this.A.c(), 0);
            this.z.b();
            this.A.a("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.z.a(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.a(var1, var2, var3);
      } else {
         var1[13] = false;
         this.z.a(13);
         return false;
      }
   }

   public final void d() {
      this.z.f();
   }

   public final void d(Graphics var1) {
      this.z.c(var1);
   }

   static thien_am a(thien_ew var0) {
      return var0.D;
   }
}
