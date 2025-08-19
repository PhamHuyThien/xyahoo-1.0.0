package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_ba extends Screen {
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
   private static TextField ap;
   public static boolean H;
   public static TextField I;
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
   private UIControlBase av;
   public static String ai;
   private UIAction aw;
   private Vector ax;
   private PopupSideElementData ay;
   private Vector az;
   private PopupSideElementData aA;
   private UIAction aB;
   private Vector aC;
   private PopupSideElementData aD;
   public static Image[] aj;
   private int aE = -1;
   private UIAction aF = new UIAction(TextConstant.smileys(), new thien_bb(this));
   private UIAction aG = new UIAction("Chat", new thien_bm(this));
   private UIAction aH = new UIAction("Đặt cược", new thien_br(this));
   private static int aI = -1;
   private PopupSideElementData aJ;
   private UIAction aK;
   private UIAction aL;
   private UIAction aM;
   private UIAction aN;
   private UIAction aO;
   private UIAction aP;

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

      UIAction var10001;
      while (true) {
         if (var3 >= var5.ax.size()) {
            var10001 = null;
            break;
         }

         UIAction var4;
         if ((var4 = (UIAction)var5.ax.elementAt(var3)).label.equals(var2)) {
            var10001 = var4;
            break;
         }

         var3++;
      }

      var10000.removeElement(var10001);
   }

   private thien_ba(int var1) {
      new UIAction("Tài khoản", new thien_bs(this));
      this.aO = new UIAction(TextConstant.update(), new thien_bt(this));
      this.aP = new UIAction("Tìm bàn", new thien_bu(this));
      z = BuddyListScreen.currentGroupName;
      if (var1 == 1) {
         super.title = TextConstant.bigTwo();
      }

      this.az = new Vector();
      this.aA = new PopupSideElementData(this.az);
      this.aB = new UIAction("Menu", new thien_bv(this));
      super.scrollLock = true;
      GameManager.f();
      this.R = false;
   }

   public final void draw(Graphics var1) {
      super.draw(var1);
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && x && !H) {
         this.addControl(I);
         J = true;
         this.selectControl(I);
      }

      return super.handleInput(var1, var2, var3);
   }

   public final void updateLayout() {
      this.al.handleFocus();
   }

   public final void drawOverlay(Graphics var1) {
      this.al.drawScrollbar(var1);
   }

   public final void a(thien_aw[] var1, int var2) {
      ah = var2;
      J = false;
      x = false;
      GameManager.instance.c();
      this.X = true;
      this.P = null;
      this.ak = null;
      this.ak = new thien_aw[var1.length];
      var2 = this.ak.length;

      while (--var2 >= 0) {
         this.ak[var2] = var1[var2];
      }

      this.j();
      super.isLocked = true;
      thien_ay.c = this.ak;
      this.clearControls();
      System.gc();
      this.al = new thien_ay(Screen.e - 3, Screen.formHeight - 3 - GameManager.g, ah);
      this.addControl(this.al);
      this.selectControl(this.al);
      super.rightCommand = this.aP;
      this.az.removeAllElements();
      this.az.addElement(this.aO);
      this.az.addElement(RoomListScreen.z);
      this.az.addElement(new UIAction("Rời phòng", new thien_bw(this)));
      super.leftCommand = this.aB;
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
      GameManager.instance.c();
      this.clearControls();
      J = false;
      thien_ay.c = null;
      this.P = null;
      this.X = true;
      this.F = null;
      byte var9 = 0;
      System.gc();
      if (this.aw == null) {
         this.ax = new Vector();
         this.ay = new PopupSideElementData(this.ax);
         this.aw = new UIAction(TextConstant.kick(), null);
         this.aw.popupSideElementData = this.ay;
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
            this.addControl(this.F[var20]);
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
         this.aD = new PopupSideElementData(this.aC);
      } else {
         this.aC.removeAllElements();
      }

      if (z.equals(this.w) && this.F.length > 1) {
         this.ax.removeAllElements();

         for (byte var22 = 0; var22 < this.F.length; var22++) {
            if (var22 != 0) {
               UIAction var15 = new UIAction(this.F[var22].a, new thien_bx(this, var22));
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

      this.aC.addElement(RoomListScreen.z);
      this.aC.addElement(new UIAction("Rời bàn", new thien_bc(this)));
      super.leftCommand = new UIAction("Menu", new thien_bd(this));
      super.rightCommand = null;
      if (z.equals(this.w)) {
         super.centerCommand = new UIAction(TextConstant.playNow(), new thien_be(this));
      } else if (!var10) {
         super.centerCommand = new UIAction(TextConstant.ready(), new thien_bf(this));
      }

      this.av = this.F[0];
      ap = null;
      (ap = new TextField("", 9, 1)).setBounds(0, Screen.formHeight - GameManager.g - (TextRenderer.fontHeight << 1) - 10, Screen.e - 1, TextRenderer.fontHeight + 6);
      if (this.aM == null) {
         this.aM = new UIAction(TextConstant.close(), new thien_bp(this));
      }

      ap.actionPrimary = this.aM;
      if (this.aN == null) {
         this.aN = new UIAction(TextConstant.bet(), new thien_bq(this));
      }

      ap.actionTertiary = this.aN;
      this.k();
      this.selectControl(this.av);
      this.j();
      System.gc();
   }

   private void j() {
      if (aI != super.scrollTargetY) {
         super.scrollTargetY = -Screen.headerHeight + 2;
         aI = super.scrollTargetY;
      }
   }

   public final void a(byte[] var1, String var2, boolean var3, boolean var4) {
      this.P = null;
      if (I != null) {
         this.removeControl(I);
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
         var5.addControl(var7);
         var5.selectControl(var7);
      }

      System.gc();
      var5.rightCommand = new UIAction(TextConstant.deny(), new thien_bg(var5, var7));
      var5.av = var5.P;
      var5.k();
      var5.leftCommand = new UIAction("Menu", new thien_bh(var5));
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
      String var4 = TextConstant.finish() + "\n";

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

         var4 = var4 + var6 + TextRenderer.truncate(this.V[var5], 14) + " " + this.ar[var5] + " xuxu" + "\n";
         if (BuddyListScreen.currentGroupName.equals(this.V[var5]) && this.ar[var5] > 0L) {
            GameManager.instance.a("Chúc mừng " + BuddyListScreen.currentGroupName + " đã thắng số tiền " + this.ar[var5] + " xuxu", (Image) null, 1);
         }
      }

      GameManager.instance.a(var4, null, null, new UIAction(TextConstant.close(), new thien_bk(this)));
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

      super.centerCommand.label = "";
      super.rightCommand = new UIAction(TextConstant.resume(), new thien_bl(this));
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
      this.F = GameManager.c(var4);
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
      (I = new TextField("", 50, 0)).setBounds(0, Screen.formHeight - GameManager.g - (TextRenderer.fontHeight << 1) - 10, Screen.e - 1, TextRenderer.fontHeight + 6);
      if (this.aK == null) {
         this.aK = new UIAction(TextConstant.cancel(), new thien_bn(this));
      }

      I.actionPrimary = this.aK;
      if (this.aL == null) {
         this.aL = new UIAction(TextConstant.send(), new thien_bo(this));
      }

      I.actionTertiary = this.aL;
   }

   public static void e(int var0) {
      x = false;
      MessageHandler.a(var0, 0, ai);
   }

   static void a(thien_ba var0) {
      var0.j();
   }

   static TextField h() {
      return ap;
   }

   static PopupSideElementData b(thien_ba var0) {
      return var0.aA;
   }

   static void a(thien_ba var0, thien_ay var1) {
      var0.al = null;
   }

   static PopupSideElementData c(thien_ba var0) {
      return var0.aD;
   }

   static PopupSideElementData d(thien_ba var0) {
      return var0.aJ;
   }

   static void a(thien_ba var0, PopupSideElementData var1) {
      var0.aJ = var1;
   }

   static UIAction e(thien_ba var0) {
      return var0.aG;
   }

   static UIAction f(thien_ba var0) {
      return var0.aF;
   }

   static UIControlBase g(thien_ba var0) {
      return var0.av;
   }
}
