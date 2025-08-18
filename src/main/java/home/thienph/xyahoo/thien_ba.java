package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ba extends thien_an {
   public String w;
   public static boolean x;
   static int y;
   private thien_aw[] ak;
   private thien_ay al;
   public static String z;
   public String[] A = new String[4];
   private long[] am = new long[4];
   private static int an;
   private static int ao;
   public static String B;
   public long C = 0L;
   public Object D;
   public boolean E;
   public thien_bz[] F;
   public String[] G;
   private static thien_at ap;
   public static boolean H;
   public static thien_at I;
   public static boolean J;
   public byte K;
   public int[] L;
   public int[] M;
   public boolean[] N;
   public boolean[] O;
   public thien_ax P;
   private boolean aq;
   public boolean Q;
   public boolean R;
   public static thien_ba S;
   public static boolean T;
   byte U;
   String[] V;
   private long[] ar;
   private long[] as;
   private byte at;
   private String[] au;
   byte[][] W;
   public boolean X = true;
   public boolean Y;
   public int Z;
   public String[] aa;
   public long[] ab;
   public long ac;
   public int[] ad;
   public String[] ae;
   public int[] af;
   public Integer[] ag;
   public static int ah;
   private thien_ac av;
   public static String ai;
   private thien_ab aw;
   private Vector ax;
   private thien_am ay;
   private Vector az;
   private thien_am aA;
   private thien_ab aB;
   private Vector aC;
   private thien_am aD;
   public static Image[] aj;
   private int aE = -1;
   private thien_ab aF = new thien_ab(thien_as.F(), new thien_bb(this));
   private thien_ab aG = new thien_ab("Chat", new thien_bm(this));
   private thien_ab aH = new thien_ab("Đặt cược", new thien_br(this));
   private static int aI = -1;
   private thien_am aJ;
   private thien_ab aK;
   private thien_ab aL;
   private thien_ab aM;
   private thien_ab aN;
   private thien_ab aO;
   private thien_ab aP;

   public static thien_ba d(int var0) {
      if (S == null) {
         S = new thien_ba(var0);
      }

      return S;
   }

   public final void b(String var1) {
      Vector var10000 = this.ax;
      String var2 = var1;
      thien_ba var5 = this;
      byte var3 = 0;

      thien_ab var10001;
      while (true) {
         if (var3 >= var5.ax.size()) {
            var10001 = null;
            break;
         }

         thien_ab var4;
         if ((var4 = (thien_ab)var5.ax.elementAt(var3)).a.equals(var2)) {
            var10001 = var4;
            break;
         }

         var3++;
      }

      var10000.removeElement(var10001);
   }

   private thien_ba(int var1) {
      new thien_ab("Tài khoản", new thien_bs(this));
      this.aO = new thien_ab(thien_as.bB(), new thien_bt(this));
      this.aP = new thien_ab("Tìm bàn", new thien_bu(this));
      z = thien_ff.y;
      if (var1 == 1) {
         super.g = thien_as.by();
      }

      this.az = new Vector();
      this.aA = new thien_am(this.az);
      this.aB = new thien_ab("Menu", new thien_bv(this));
      super.u = true;
      thien_di.f();
      this.R = false;
   }

   public final void a(Graphics var1) {
      super.a(var1);
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && x && !H) {
         this.a(I);
         J = true;
         this.c(I);
      }

      return super.a(var1, var2, var3);
   }

   public final void d() {
      this.al.f();
   }

   public final void d(Graphics var1) {
      this.al.c(var1);
   }

   public final void a(thien_aw[] var1, int var2) {
      ah = var2;
      J = false;
      x = false;
      thien_di.c.c();
      this.X = true;
      this.P = null;
      this.ak = null;
      this.ak = new thien_aw[var1.length];
      var2 = this.ak.length;

      while (--var2 >= 0) {
         this.ak[var2] = var1[var2];
      }

      this.j();
      super.p = true;
      thien_ay.c = this.ak;
      this.a();
      System.gc();
      this.al = new thien_ay(thien_an.e - 3, thien_an.f - 3 - thien_di.g, ah);
      this.a(this.al);
      this.c(this.al);
      super.l = this.aP;
      this.az.removeAllElements();
      this.az.addElement(this.aO);
      this.az.addElement(thien_em.z);
      this.az.addElement(new thien_ab("Rời phòng", new thien_bw(this)));
      super.k = this.aB;
      System.gc();
   }

   public static void e() {
      x = false;
      MessageHandler.b(ai);
   }

   private static void i() {
      if (aj == null) {
         aj = new Image[4];

         try {
            for (int var0 = 0; var0 < 4; var0++) {
               aj[var0] = Image.createImage("/av" + var0 + ".png");
            }

            return;
         } catch (Exception var1) {
            System.out.println("sdsdsdsd = " + var1.toString());
         }
      }
   }

   public final void a(byte var1, String[] var2, long[] var3, int[] var4, String[] var5, int[] var6, Integer[] var7, String var8) {
      x = true;
      ah = 1;
      thien_di.c.c();
      this.a();
      J = false;
      thien_ay.c = null;
      this.P = null;
      this.X = true;
      this.F = null;
      byte var9 = 0;
      System.gc();
      if (this.aw == null) {
         this.ax = new Vector();
         this.ay = new thien_am(this.ax);
         this.aw = new thien_ab(thien_as.j(), null);
         this.aw.c = this.ay;
      }

      this.F = new thien_bz[var1];
      this.K = var1;
      this.L = var4;
      boolean var10 = false;

      for (byte var11 = 0; var11 < var2.length; var11++) {
         this.A[var11] = var2[var11];
         this.am[var11] = var3[var11];
      }

      for (byte var17 = 0; var17 < var1; var17++) {
         if (var2[var17] != null) {
            var9++;
         }
      }

      byte[] var18 = new byte[var1];
      byte var12 = 0;
      byte var13 = 0;

      for (byte var14 = 0; var14 < var1; var14++) {
         if (z.equals(var2[var14])) {
            var12 = var14;
            break;
         }
      }

      for (byte var20 = 0; var20 < var1; var20++) {
         var18[var20] = var12;
         if (var12 == var1 - 1) {
            var12 = 0;
         } else {
            var12++;
         }

         var13 = var18[var20];
         if (var2[var13] != null) {
            this.F[var20] = new thien_bz(var2[var13], var3[var13], var20, var4[var13], var2[var13].equals(this.w), var5[var13], var6[var13], var7[var13]);
            this.F[var20].g = this.O[var13];
         }

         if (z.equals(this.F[var20].a)) {
            an = this.F[var20].e;
            ao = this.F[var20].f;
            var10 = this.F[var20].g;
         }

         if (this.F[var20] != null) {
            this.a(this.F[var20]);
         }
      }

      i();
      if (var1 > 0) {
         if (this.aE == -1 || !var8.equals(B)) {
            this.aE = (int)(System.currentTimeMillis() % 4L);
         }

         int var21 = this.aE;
         this.F[0].F = this.aE;

         for (int var16 = 1; var16 < var1; var16++) {
            if (var21 == 3) {
               var21 = 0;
            } else {
               var21++;
            }

            this.F[var16].F = var21;
         }
      }

      if (this.aC == null) {
         this.aC = new Vector();
         this.aD = new thien_am(this.aC);
      } else {
         this.aC.removeAllElements();
      }

      if (z.equals(this.w) && this.F.length > 1) {
         this.ax.removeAllElements();

         for (byte var22 = 0; var22 < this.F.length; var22++) {
            if (var22 != 0) {
               thien_ab var15 = new thien_ab(this.F[var22].a, new thien_bx(this, var22));
               this.ax.addElement(var15);
            }
         }

         this.aC.addElement(this.aw);
      }

      this.aC.addElement(this.aF);
      this.aC.addElement(this.aG);
      if (var9 == 1) {
         this.aC.addElement(this.aH);
      }

      this.aC.addElement(thien_em.z);
      this.aC.addElement(new thien_ab("Rời bàn", new thien_bc(this)));
      super.k = new thien_ab("Menu", new thien_bd(this));
      super.l = null;
      if (z.equals(this.w)) {
         super.m = new thien_ab(thien_as.k(), new thien_be(this));
      } else if (!var10) {
         super.m = new thien_ab(thien_as.bz(), new thien_bf(this));
      }

      this.av = this.F[0];
      ap = null;
      (ap = new thien_at("", 9, 1)).a(0, thien_an.f - thien_di.g - (thien_w.f << 1) - 10, thien_an.e - 1, thien_w.f + 6);
      if (this.aM == null) {
         this.aM = new thien_ab(thien_as.ae(), new thien_bp(this));
      }

      ap.w = this.aM;
      if (this.aN == null) {
         this.aN = new thien_ab(thien_as.bA(), new thien_bq(this));
      }

      ap.y = this.aN;
      this.k();
      this.c(this.av);
      this.j();
      System.gc();
   }

   private void j() {
      if (aI != super.q) {
         super.q = -thien_an.d + 2;
         aI = super.q;
      }
   }

   public final void a(byte[] var1, String var2, boolean var3, boolean var4) {
      this.P = null;
      if (I != null) {
         this.b(I);
      }

      J = false;
      System.gc();
      this.P = new thien_ax(var1);
      thien_ax.l = var4;
      this.P.b = var2;
      this.D = var2;
      if (z.equals(var2)) {
         this.aq = var3;
         this.P.e = var3;
      }

      this.P.h = true;
      this.P.g = false;
      this.P.i = an;
      this.P.j = ao + 8;
      thien_ax var7 = this.P;
      thien_ba var5 = this;

      for (byte var8 = 0; var8 < var5.F.length; var8++) {
         if (var5.F[var8] != null) {
            var5.F[var8].a(false);
         }
      }

      var5.Y = false;
      var5.X = false;
      var5.Q = false;
      if (var7 != null) {
         var7.e = var5.aq;
         var7.f = false;
         var5.a(var7);
         var5.c(var7);
      }

      System.gc();
      var5.l = new thien_ab(thien_as.bC(), new thien_bg(var5, var7));
      var5.av = var5.P;
      var5.k();
      var5.k = new thien_ab("Menu", new thien_bh(var5));
      System.gc();

      for (byte var6 = 0; var6 < S.K; var6++) {
         if (S.F[var6].a != null && S.F[var6].a.equals(var2)) {
            S.F[var6].c(30);
            return;
         }
      }
   }

   public final void a(String var1, int var2, byte[] var3, String var4, boolean var5) {
      this.Q = true;
      this.D = var4;
      if (this.P != null) {
         thien_bz var6 = new thien_bz();

         for (byte var7 = 0; var7 < this.K; var7++) {
            if (this.F[var7].a != null && this.F[var7].a.equals(var1)) {
               var6 = this.F[var7];
            }
         }

         this.P.f = true;
         this.P.h = var5;
         this.P.a = var1;
         this.P.b = var4;
         this.P.c = var2;
         this.P.e = false;
         this.P.n = false;
         if (this.P.h) {
            this.P.g = false;

            for (int var8 = 0; var8 < S.K; var8++) {
               this.F[var8].l = false;
            }
         } else {
            var6.l = false;
         }

         this.P.a(var3, var6.e, var6.f);

         for (byte var9 = 0; var9 < this.K; var9++) {
            if (this.F[var9].a != null) {
               if (this.F[var9].a.equals(this.D)) {
                  this.F[var9].c(30);
               } else {
                  this.F[var9].G = false;
               }
            }
         }
      }
   }

   public final void a(String var1, String var2, boolean var3) {
      this.P.h = var3;
      this.P.b = var2;
      this.D = var2;
      this.P.k = var1;
      if (this.P.e) {
         this.P.e = false;
      }

      if (this.P.h) {
         this.P.g = false;
         this.P.d = null;
         this.P.m = null;

         for (byte var4 = 0; var4 < this.K; var4++) {
            this.F[var4].l = false;
         }
      } else {
         for (byte var5 = 0; var5 < this.K; var5++) {
            if (this.F[var5].a.equals(var1)) {
               this.F[var5].l = true;
               break;
            }
         }
      }

      for (byte var6 = 0; var6 < this.K; var6++) {
         if (this.F[var6].a.equals(var1)) {
            this.F[var6].G = false;
         } else if (this.F[var6].a.equals(var2)) {
            this.F[var6].c(30);
         }
      }
   }

   public final void a(
      String var1, byte var2, String[] var3, long[] var4, long[] var5, byte var6, String[] var7, byte[][] var8, String[] var9, int[] var10, Integer[] var11
   ) {
      if (B.equals(var1)) {
         this.U = var2;
         this.V = var3;
         this.ar = var4;
         this.as = var5;
         this.at = var6;
         this.au = var7;

         for (byte var12 = 0; var12 < this.K; var12++) {
            if (this.F[var12] != null) {
               this.F[var12].G = false;

               for (byte var13 = 0; var13 < var3.length; var13++) {
                  if (this.F[var12].a.equals(var3[var13])) {
                     this.F[var12].b = var5[var13];
                     this.F[var12].C = var9[var13];
                     this.F[var12].D = var10[var13];
                     this.F[var12].E = var11[var13];
                     break;
                  }
               }
            }
         }

         this.E = false;
         if (var1.equals(var1)) {
            this.W = var8;
            this.P.b();
         }
      }
   }

   public final void f() {
      String[] var1 = new String[this.at];
      long[] var2 = new long[this.at];
      int[] var3 = new int[this.at];
      String var4 = thien_as.g() + "\n";

      for (int var5 = 0; var5 < this.V.length; var5++) {
         String var6;
         if (this.M[var5] == 1) {
            var6 = "Tới nhất: ";
         } else if (this.M[var5] == 2) {
            var6 = "Tới nhì: ";
         } else if (this.M[var5] == 3) {
            var6 = "Tới ba: ";
         } else {
            var6 = "Tới bét: ";
         }

         var4 = var4 + var6 + thien_w.a(this.V[var5], 14) + " " + this.ar[var5] + " xuxu" + "\n";
         if (thien_ff.y.equals(this.V[var5]) && this.ar[var5] > 0L) {
            thien_di.c.a("Chúc mừng " + thien_ff.y + " đã thắng số tiền " + this.ar[var5] + " xuxu", (Image) null, 1);
         }
      }

      thien_di.c.a(var4, null, null, new thien_ab(thien_as.ae(), new thien_bk(this)));
      boolean var8 = false;

      for (int var9 = 0; var9 < this.at; var9++) {
         for (int var7 = 0; var7 < this.K; var7++) {
            if (!var8 && this.as[var7] < this.C && this.V[var7] != null && z.equals(this.V[var7])) {
               var8 = true;
            }

            if (this.F[var7].a != null && this.F[var7].a.equals(this.au[var9])) {
               var1[var9] = this.F[var7].a;
               var2[var9] = this.F[var7].b;
               var3[var9] = this.F[var7].c;
               break;
            }
         }
      }

      super.m.a = "";
      super.l = new thien_ab(thien_as.bx(), new thien_bl(this));
   }

   public final void g() {
      Vector var1 = new Vector();

      for (int var2 = 0; var2 < this.N.length; var2++) {
         if (!this.N[var2]) {
            var1.addElement(this.au[var2]);
         }
      }

      String[] var4 = new String[var1.size()];
      var1.copyInto(var4);
      this.F = thien_di.c(var4);
      this.Z = var4.length;

      for (int var3 = 0; var3 < var4.length; var3++) {
         this.aa[var3] = S.F[var3].a;
         this.ab[var3] = S.F[var3].b;
         this.ad[var3] = S.F[var3].c;
         this.ae[var3] = S.F[var3].C;
         this.af[var3] = S.F[var3].D;
         this.ag[var3] = S.F[var3].E;
         this.O[var3] = false;
      }
   }

   public final void b(String var1, String var2, boolean var3) {
      this.P.b = var2;
      this.P.h = var3;
      S.D = var2;
      if (this.P.h) {
         this.P.g = false;
         this.P.d = null;
         this.P.m = null;
      }

      for (int var4 = 0; var4 < this.F.length; var4++) {
         if (this.F[var4] != null) {
            this.F[var4].l = false;
            if (!this.P.e && this.F[var4].a.equals(var2)) {
               this.F[var4].c(30);
            }
         }
      }

      for (byte var5 = 0; var5 < this.F.length; var5++) {
         if (this.F[var5].a.equals(var1)) {
            this.F[var5].j = true;
         }
      }
   }

   private void k() {
      I = null;
      (I = new thien_at("", 50, 0)).a(0, thien_an.f - thien_di.g - (thien_w.f << 1) - 10, thien_an.e - 1, thien_w.f + 6);
      if (this.aK == null) {
         this.aK = new thien_ab(thien_as.z(), new thien_bn(this));
      }

      I.w = this.aK;
      if (this.aL == null) {
         this.aL = new thien_ab(thien_as.t(), new thien_bo(this));
      }

      I.y = this.aL;
   }

   public static void e(int var0) {
      x = false;
      MessageHandler.a(var0, 0, ai);
   }

   static void a(thien_ba var0) {
      var0.j();
   }

   static thien_at h() {
      return ap;
   }

   static thien_am b(thien_ba var0) {
      return var0.aA;
   }

   static void a(thien_ba var0, thien_ay var1) {
      var0.al = null;
   }

   static thien_am c(thien_ba var0) {
      return var0.aD;
   }

   static thien_am d(thien_ba var0) {
      return var0.aJ;
   }

   static void a(thien_ba var0, thien_am var1) {
      var0.aJ = var1;
   }

   static thien_ab e(thien_ba var0) {
      return var0.aG;
   }

   static thien_ab f(thien_ba var0) {
      return var0.aF;
   }

   static thien_ac g(thien_ba var0) {
      return var0.av;
   }
}
