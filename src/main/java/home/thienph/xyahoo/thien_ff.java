package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class thien_ff extends thien_an {
   public static int[] w;
   public thien_b x;
   public static String y;
   public static String z;
   public static String A;
   public static int B;
   public static boolean C;
   public static String D = "";
   public static String E;
   public static byte F;
   public static String G;
   public static int H;
   private Vector J;
   public thien_am I;
   private boolean K;
   private final thien_at L;

   public static void e() {
      E = null;
   }

   public final void f() {
      String var1;
      if (!(var1 = this.x.g()).equals(thien_as.bl())) {
         thien_cl var2;
         (var2 = new thien_cl(thien_as.aE(), thien_as.aF() + "\"" + this.x.g() + "\"")).D.a(var1);
         var2.a(new thien_fg(this, var2, var1));
         thien_di.b().b(var2);
         thien_di.b().j();
      }
   }

   public final void g() {
      thien_cl var1;
      (var1 = new thien_cl(thien_as.B(), thien_as.aO())).a(new thien_fq(this, var1));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   public final void a(String var1, int var2) {
      if (var2 == 0) {
         thien_ew var3 = thien_di.b().e(var1);
         thien_di.b().d(var3.g);
      } else {
         if (var2 == 1) {
            this.b(var1);
         }
      }
   }

   public final void h() {
      thien_an var1;
      (var1 = new thien_an()).g = thien_as.ah();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      thien_ai var5 = new thien_ai(thien_as.aP(), var3, 10, thien_w.f);
      int var4 = 10 + 1 + var5.t;
      thien_at var6;
      (var6 = new thien_at()).a(var3, var4, var2, thien_w.f + 6);
      var6.d(100);
      var6.a("");
      var1.a(var5);
      var1.a(var6);
      var1.c(var6);
      var1.m = new thien_ab("OK", new thien_gb(this, var6, var1));
      var1.k = new thien_ab(thien_as.z(), new thien_gi(this, var1));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   public final void b(String var1) {
      thien_di.e = thien_di.b().u();
      thien_an var2;
      (var2 = new thien_an()).g = thien_as.y();
      int var3;
      if ((var3 = GameCanvas.screenWidth - 30) > 150) {
         var3 = 180;
      }

      if (var3 < 100) {
         var3 = 100;
      }

      int var4 = GameCanvas.screenWidth - var3 >> 1;
      thien_ai var6 = new thien_ai(thien_as.w(), var4, 10, thien_w.f);
      int var5 = 10 + 1 + var6.t;
      thien_at var7;
      (var7 = new thien_at()).a(var4, var5, var3, thien_w.f + 6);
      var7.a(var1);
      var5 += 5 + var7.t;
      thien_ai var11 = new thien_ai(thien_as.x(), var4, var5, thien_w.f);
      var5 += 1 + var11.t;
      thien_at var8;
      (var8 = new thien_at()).a(var4, var5, var3, thien_w.f + 6);
      String var9 = this.x.g();
      var8.a(var9);
      if (var8.c().equals("") || var8.c().equals(thien_as.bl())) {
         var8.a("Friends");
      }

      var5 += 5 + var8.t;
      thien_ai var10 = new thien_ai(thien_as.aI(), var4, var5, thien_w.f);
      var5 += 1 + var10.t;
      thien_z var12;
      (var12 = new thien_z(this.x.i(), var4, var5, var3, thien_w.f + 6)).a(var9);
      var12.b = new thien_gj(this, var8, var12);
      var2.a(var6);
      var2.a(var7);
      var2.a(var11);
      var2.a(var8);
      var2.a(var10);
      var2.a(var12);
      var2.c(var7);
      var2.m = new thien_ab("OK", new thien_gk(this, var7, var8, var2));
      var2.k = new thien_ab(thien_as.z(), new thien_gl(this, var2));
      thien_di.c.a(var2);
      thien_di.b().j();
   }

   public final void i() {
      thien_an var1;
      (var1 = new thien_an()).g = thien_as.bo();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      thien_ai var5 = new thien_ai(thien_as.bp(), var3, 10, thien_w.f);
      int var4 = 10 + 5 + var5.t;
      thien_at var6;
      (var6 = new thien_at()).a(var3, var4, var2, thien_w.f + 6);
      var4 += 5 + var6.t;
      thien_ai var7 = new thien_ai(thien_as.bq(), var3, var4, thien_w.f);
      var4 += 1 + var7.t;
      thien_z var8;
      (var8 = new thien_z(this.x.i(), var3, var4, var2, thien_w.f + 6)).a(this.x.g());
      var1.a(var5);
      var1.a(var6);
      var1.a(var7);
      var1.a(var8);
      var1.c(var6);
      var1.m = new thien_ab("OK", new thien_gm(this, var6, var8, var1));
      Vector var9;
      (var9 = new Vector()).addElement(new thien_ab(thien_as.bn(), new thien_gn(this, var6)));
      var9.addElement(new thien_ab(thien_as.z(), new thien_fh(this, var1)));
      thien_am var10 = new thien_am(var9);
      var1.k = new thien_ab("Menu", new thien_fi(this, var10));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   public final void j() {
      String var1;
      if (!(var1 = this.x.h().d).equals(thien_as.bm())) {
         thien_an var2;
         (var2 = new thien_an()).g = thien_as.aK();
         int var3;
         if ((var3 = GameCanvas.screenWidth - 30) > 150) {
            var3 = 180;
         }

         if (var3 < 100) {
            var3 = 100;
         }

         int var4 = GameCanvas.screenWidth - var3 >> 1;
         thien_ai var6 = new thien_ai(thien_as.aJ() + var1, var4, 10, thien_w.f);
         int var5 = 10 + 5 + var6.t;
         thien_ai var7 = new thien_ai(thien_as.x(), var4, var5, thien_w.f);
         var5 += 1 + var7.t;
         thien_at var8;
         (var8 = new thien_at()).a(var4, var5, var3, thien_w.f + 6);
         String var9 = this.x.g();
         var8.a(var9);
         if (var8.c().equals("") || var8.c().equals(thien_as.bl())) {
            var8.a("Friends");
         }

         var5 += 5 + var8.t;
         thien_ai var10 = new thien_ai(thien_as.aI(), var4, var5, thien_w.f);
         var5 += 1 + var10.t;
         thien_z var11;
         (var11 = new thien_z(this.x.i(), var4, var5, var3, thien_w.f + 6)).a(var9);
         var11.b = new thien_fj(this, var8, var11);
         var2.a(var6);
         var2.a(var7);
         var2.a(var8);
         var2.a(var10);
         var2.a(var11);
         var2.c(var8);
         var2.m = new thien_ab("OK", new thien_fk(this, var8, var2, var9, var1));
         var2.k = new thien_ab(thien_as.z(), new thien_fl(this, var2));
         thien_di.b().b(var2);
         thien_di.b().j();
      }
   }

   public final void k() {
      thien_an var1;
      (var1 = new thien_an()).g = thien_as.ar();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      thien_ai var5 = new thien_ai(thien_as.as(), var3, 10, thien_w.f);
      int var4 = 10 + 1 + var5.t;
      thien_at var6;
      (var6 = new thien_at()).a(var3, var4, var2, thien_w.f + 6);
      var6.d(255);
      var6.a(D);
      var4 += 10 + var6.t;
      thien_ai var7 = new thien_ai(thien_as.ar(), var3, var4, thien_w.f);
      var4 += 1 + var7.t;
      thien_z var8 = new thien_z(new String[]{thien_as.aQ(), thien_as.aR()}, var3, var4, var2, thien_w.f + 6);
      var8.c(B == 1 ? 0 : 1);
      var8.b = new thien_fm(this);
      var1.a(var5);
      var1.a(var6);
      var1.a(var7);
      var1.a(var8);
      var1.c(var6);
      var1.m = new thien_ab("OK", new thien_fn(this, var6, var8, var1));
      var1.k = new thien_ab(thien_as.z(), new thien_fo(this, var1));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   protected final void l() {
      thien_an var1;
      (var1 = new thien_an()).g = thien_as.ba();
      int var2;
      if ((var2 = GameCanvas.screenWidth - 30) > 150) {
         var2 = 180;
      }

      if (var2 < 100) {
         var2 = 100;
      }

      int var3 = GameCanvas.screenWidth - var2 >> 1;
      thien_ai var5 = new thien_ai(thien_as.bc(), var3, 10, thien_w.f);
      int var4 = 10 + 1 + var5.t;
      thien_at var6;
      (var6 = new thien_at()).e(2);
      var6.a(var3, var4, var2, thien_w.f + 6);
      var4 += var6.t + 6;
      thien_ai var7 = new thien_ai(thien_as.bd(), var3, var4, thien_w.f);
      var4 += 1 + var7.t;
      thien_at var8;
      (var8 = new thien_at()).e(2);
      var8.a(var3, var4, var2, thien_w.f + 6);
      var4 += var8.t + 6;
      thien_ai var9 = new thien_ai(thien_as.Z(), var3, var4, thien_w.f);
      var4 += 1 + var7.t;
      thien_at var10;
      (var10 = new thien_at()).e(2);
      var10.a(var3, var4, var2, thien_w.f + 6);
      var1.a(var5);
      var1.a(var6);
      var1.a(var7);
      var1.a(var8);
      var1.a(var9);
      var1.a(var10);
      var1.c(var6);
      var1.m = new thien_ab("OK", new thien_fp(this, var6, var8, var10, var1));
      var1.k = new thien_ab(thien_as.z(), new thien_fr(this, var1));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   protected final void m() {
      thien_cl var1;
      (var1 = new thien_cl(thien_as.aZ(), thien_as.aZ())).D.a(z);
      var1.a(new thien_fs(this, var1));
      thien_di.b().b(var1);
      thien_di.b().j();
   }

   public thien_ff() {
      C = Xuka.readFlag("onrank", false);
      super.p = true;
      super.g = thien_as.b();
      this.L = new thien_at();
      this.L.a = true;
      this.L.a(0, thien_an.f - thien_di.g - thien_w.f - 11, thien_an.e - 6, thien_w.f + 6);
      this.x = new thien_b(1, 1, thien_an.e - 3, thien_an.f - 2 - thien_di.g, true);
      this.x.c = false;
      this.x.n = true;
      this.a(this.x);
      this.c(this.x);
      this.J = new Vector();
      this.J.addElement(new thien_ab(thien_as.y(), new thien_ft(this)));
      this.J.addElement(new thien_ab(thien_as.ar(), new thien_fu(this)));
      Vector var1;
      (var1 = new Vector()).addElement(new thien_ab(thien_as.ay(), new thien_fv(this)));
      var1.addElement(new thien_ab("Avatar", new thien_fw(this)));
      thien_ab var2;
      (var2 = new thien_ab(thien_as.r(), null)).c = new thien_am(var1);
      this.J.addElement(var2);
      (var1 = new Vector()).addElement(new thien_ab(thien_as.aZ(), new thien_fx(this)));
      var1.addElement(new thien_ab(thien_as.ba(), new thien_fy(this)));
      (var2 = new thien_ab(thien_as.bb(), null)).c = new thien_am(var1);
      this.J.addElement(var2);
      (var1 = new Vector()).addElement(new thien_ab(thien_as.af(), new thien_fz(this)));
      var1.addElement(new thien_ab(thien_as.ag(), new thien_ga(this)));
      var1.addElement(new thien_ab(thien_as.bj(), new thien_gc(this)));
      var1.addElement(new thien_ab(thien_as.E(), new thien_gd(this)));
      var1.addElement(new thien_ab(thien_as.ah(), new thien_ge(this)));
      var1.addElement(new thien_ab(thien_as.bo(), new thien_gf(this)));
      (var2 = new thien_ab(thien_as.bi(), null)).c = new thien_am(var1);
      this.J.addElement(var2);
      this.J.addElement(new thien_ab(thien_as.ae(), new thien_gg(this)));
      this.I = new thien_am(this.J);
      super.k = new thien_ab("Menu", new thien_gh(this));
   }

   public static void n() {
      MessageHandler.d();
      thien_di.c.a(thien_di.t);
   }

   public final void o() {
      if (this.x.l != null) {
         this.x.l.removeAllElements();
      }

      this.x.l = null;
      this.x.k = null;
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.K) {
         this.L.a("");
         this.a(this.L);
         this.c(this.L);
         this.K = true;
      }

      String var4 = "";
      if (this.K) {
         if (var1[12]) {
            var1[12] = false;
            this.x.b(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.x.b(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.x.b(16);
         }

         var4 = this.L.c();
      }

      super.a(var1, var2, var3);
      if (this.K) {
         if (this.L.c().equals("")) {
            this.c(this.x);
            this.b(this.L);
            this.K = false;
         }

         if (!this.L.c().equals(var4)) {
            this.x.d(this.L.c());
         }
      }

      return true;
   }

   public final void d() {
      this.x.f();
   }

   public final void d(Graphics var1) {
      this.x.c(var1);
   }
}
