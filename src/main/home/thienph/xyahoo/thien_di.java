package home.thienph.xyahoo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_di implements thien_et {
   private static boolean H;
   public static boolean a;
   public static String b;
   private String I;
   private String J;
   private static String K = "";
   public static thien_di c = new thien_di();
   public Vector d;
   private Vector L;
   public static thien_an e;
   private int M;
   public static int f;
   private static int N;
   public static int g;
   private static int O;
   private static int P;
   private static int Q = 15;
   public int h;
   private int R;
   private int S;
   private int T;
   private int U;
   private int V;
   public thien_ae i;
   private int W;
   public thien_ff j;
   public thien_gp k;
   public thien_cq l;
   private thien_eh X;
   public thien_cn m;
   private boolean Y;
   public Vector n = new Vector();
   private int[] Z = new int[3];
   private String[] aa = new String[3];
   private int[] ab = new int[3];
   private int[] ac = new int[3];
   private int[] ad = new int[3];
   private int[] ae = new int[3];
   private int[] af = new int[3];
   private int[] ag = new int[3];
   private Image[] ah = new Image[3];
   private boolean ai;
   private Vector aj;
   public static String o = "";
   private boolean ak;
   private Image al;
   private String[] am;
   private int an;
   private boolean ao;
   private int ap;
   private int aq;
   private int ar;
   private int as;
   private int at;
   private int au;
   private int av;
   public static boolean p = false;
   public static boolean q = true;
   public static boolean r = true;
   public static boolean s = false;
   private static Image aw;
   private static Image ax;
   public static Vector t;
   public static Image u;
   public static Image v;
   public static Image w;
   public static Image x;
   public static Image[] y;
   private static Image ay;
   private thien_ab az;
   private thien_ab aA;
   private thien_ae aB;
   private int aC;
   private thien_an aD;
   private int aE;
   private int aF = 0;
   private int aG = 0;
   private boolean aH;
   public static boolean z;
   private static int aI;
   private static byte[] aJ;
   private boolean aK;
   public boolean A;
   String B = "";
   int C = 0;
   public static String D;
   public static String E;
   thien_ca F;
   public static thien_em G;

   static {
      try {
         aw = Image.createImage("/Load.png");
      } catch (Exception var0) {
      }

      aJ = new byte[1];
   }

   private void e(thien_an var1) {
      this.L.addElement(var1);
      this.aE = this.L.size();
      var1.b(this.U - 30);
      if (this.aE == 1) {
         this.W = 0;
         this.D();
      }
   }

   private void D() {
      this.aD = (thien_an)this.L.elementAt(this.W);
      if (this.aD.t) {
         this.aD.t = false;
         this.aF = 0;
         this.aG = 0;
      }

      thien_ar.a = false;
      this.aD.d();
   }

   public final void a(thien_an var1) {
      this.e(var1);
   }

   public final void b(thien_an var1) {
      thien_an var3 = var1;
      thien_di var2 = this;
      int var4 = this.aE;

      boolean var10000;
      while (true) {
         if (--var4 < 0) {
            var10000 = false;
            break;
         }

         if (((thien_an)var2.L.elementAt(var4)).g.equals(var3.g)) {
            var10000 = true;
            break;
         }
      }

      if (!var10000) {
         this.e(var1);
      }
   }

   public final void a(Graphics var1, int var2, int var3) {
      var1.drawRegion(aw, 0, this.h % 4 == 0 ? this.T++ * 6 : this.T * 6, 46, 6, 0, var2, var3, 3);
      this.T = this.T > 4 ? 0 : this.T;
   }

   private void b(Graphics var1) {
      if (this.ao) {
         var1.setClip(this.ar + 1, this.as + 1, this.at - 1, this.au - 1);
         int var2 = this.at / 50 + 1;

         while (--var2 >= 0) {
            int var3 = this.au / 50 + 1;

            while (--var3 >= 0) {
               var1.drawImage(w, this.ar + var2 * 50, this.av + var3 * 50, 0);
            }
         }

         var1.setClip(this.ar - 1, this.as, this.at + 2, this.au + 2);
         var1.setColor(14545919);
         thien_v.a(var1, this.ar, this.av, this.at, this.au);
         var1.setColor(10278388);
         var1.fillRoundRect(5 + this.ar + this.ap * 20, 5 + this.av + this.aq * 20, 20, 20, 5, 5);
         int var5 = 7;

         while (--var5 >= 0) {
            var2 = 6;

            while (--var2 >= 0) {
               var1.drawRegion(u, (var5 * 6 + var2) * 18, 0, 18, 18, 0, 5 + this.ar + var2 * 20 + 10, 5 + this.av + var5 * 20 + 10, 3);
            }
         }

         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         var1.setClip(-1000, -1000, 2000, 2000);
         thien_an.c(var1);
         var1.setColor(16777215);
         thien_w.a(thien_w.d).a(thien_as.P(), 4, thien_d.k - (g >> 1) - (thien_w.f >> 1), var1);
         thien_w.a(thien_w.d).a(thien_as.z(), this.U - 4, thien_d.k - (g >> 1) - (thien_w.f >> 1), 1, var1, thien_w.j, thien_w.f);
      }
   }

   public final void a(String var1, Image var2, int var3) {
      if (this.Z[var3] == 0) {
         this.ah[var3] = var2;
         int var4 = this.ah[var3] != null ? this.ah[var3].getWidth() : 0;
         this.aa[var3] = var1;
         this.ab[var3] = thien_w.a(var1, thien_w.j) + 15 + var4;
         if (this.Z[var3] == 0) {
            this.Z[var3] = 1;
         }

         this.ae[var3] = thien_w.f + 6;
         if (this.ah[var3] != null && this.ae[var3] < this.ah[var3].getHeight() + 6) {
            this.ae[var3] = this.ah[var3].getHeight() + 6;
         }

         if (var3 == 0) {
            this.ac[var3] = thien_d.j - this.ab[var3] - 2;
            this.af[var3] = this.ad[var3] + this.ae[var3];
         } else if (var3 == 1) {
            this.ac[var3] = thien_d.j;
            this.af[var3] = this.ad[var3];
         } else {
            this.ac[var3] = thien_d.j - this.ab[var3] - 2;
            this.af[var3] = this.ad[var3] - this.ae[var3] + 1;
         }
      }
   }

   public final void a() {
      if (q) {
         Display.getDisplay(Xuka.g).vibrate(500);
      }
   }

   public final void a(int var1) {
      if (!this.Y) {
         this.at = 129;
         this.au = 149;
         this.ar = 2;
         this.as = this.V - g - this.au - 2;
         this.av = this.V - g - 2;
         this.ao = true;
      }
   }

   public static thien_di b() {
      return c;
   }

   public final thien_ad a(String var1, thien_ab var2, thien_ab var3, thien_ab var4) {
      this.ai = false;
      thien_ad var5 = new thien_ad(var1, var2, var3, var4);
      this.n.addElement(var5);
      this.Y = true;
      return var5;
   }

   private thien_ad a(String[] var1, thien_ab var2, thien_ab var3, thien_ab var4) {
      this.ai = false;
      thien_ad var5 = new thien_ad(var1, var2, var3, var4);
      this.n.addElement(var5);
      this.Y = true;
      return var5;
   }

   public final void c() {
      if (this.n.size() > 0) {
         this.n.removeElementAt(0);
      }

      if (this.n.size() == 0) {
         this.Y = false;
      }
   }

   protected thien_di() {
   }

   public final void a(int var1, int var2) {
      H = Xuka.c[0].startsWith("10.") || Xuka.c[0].endsWith(".0.1");
      a = Xuka.c[0].endsWith("113") || H;
      System.out.println("X Yahoo! = " + a);
      System.gc();
      this.U = var1;
      this.V = var2;
      this.L = new Vector();
      this.aj = new Vector();
      t = new Vector();

      try {
         Image var3 = Image.createImage("/TabBar.png");
         Graphics var4 = (v = Image.createImage(thien_d.j, 18)).getGraphics();
         int var5 = (thien_d.j - 128 >> 5) + 1;

         while (--var5 >= 0) {
            var4.drawRegion(var3, 64, 0, 32, 18, 0, 64 + (var5 << 5), 0, 20);
         }

         var4.drawRegion(var3, 0, 0, 64, 18, 0, 0, 0, 20);
         var4.drawRegion(var3, 0, 0, 64, 18, 2, thien_d.j - 64, 0, 20);
         System.gc();
      } catch (Exception var11) {
      }

      this.M = thien_w.f + 3;
      N = 1;
      O = 1;
      g = thien_w.a ? v.getHeight() : thien_w.f + 3;
      thien_an.b = f = g = thien_w.a ? 18 : thien_w.f + 3;
      P = g + 1;
      this.ad[0] = thien_d.k - g - thien_w.f - 8;
      this.ad[1] = this.ad[2] = O + g + 1;
      this.ag[0] = 1;
      this.ag[1] = 2;
      this.ag[2] = 1;
      p = Xuka.b("sound", false);
      q = Xuka.b("vibrate", true);
      r = Xuka.b("atlog", true);
      s = Xuka.b("atlogY", false);

      try {
         u = Image.createImage("/Smileys.png");
         x = Image.createImage("/DlgTop.png");
         w = Image.createImage("/DlgBg.png");
         Image var12 = Image.createImage("/bg.png");
         int var13 = thien_d.k - (g << 1);
         Graphics var14 = (ax = Image.createImage(thien_d.j, var13)).getGraphics();
         int var6 = thien_d.j / 32 + 1;
         int var7 = (var13 - var12.getHeight()) / 32 + 1;

         for (int var8 = 0; var8 < var6; var8++) {
            for (int var9 = 0; var9 < var7; var9++) {
               var14.drawRegion(var12, 0, 0, 32, 32, 0, var8 << 5, var9 << 5, 0);
            }
         }

         for (int var15 = 0; var15 < var6; var15++) {
            var14.drawImage(var12, var15 << 5, var13 - var12.getHeight(), 0);
         }

         System.gc();
         y = new Image[2];

         for (int var16 = 0; var16 < 2; var16++) {
            y[var16] = Image.createImage("/ch" + var16 + ".png");
         }
      } catch (Exception var10) {
      }

      thien_b.a();
      ax.getHeight();
      this.R = g;
      this.S = g - 7 >> 1;
      thien_an.c = 0;
      thien_an.d = P;
      thien_an.e = var1;
      thien_an.f = var2 - P;
      thien_an.v = P + thien_an.f - (g >> 1) - (thien_w.f >> 1) + (thien_w.a ? 0 : 1);
      this.l = new thien_cq();
      this.l.a(1);
      this.b(this.l);
      this.W = 0;
      this.D();
      if (thien_d.l) {
         thien_at.c(1);
      } else if (Xuka.h != null && Xuka.h.toLowerCase().indexOf("nokia") != -1) {
         thien_at.c(0);
      } else {
         thien_at.c(2);
      }

      thien_at.e = thien_d.a;
      thien_at.f = Xuka.g;
      thien_at.c = Xuka.g();
      thien_d.m = true;
   }

   public final void d() {
      if (thien_hc.d) {
         this.a(thien_as.bv(), null, null, new thien_ab(thien_as.ae(), new thien_dj(this))).a(true);
      } else if (this.aK) {
         this.c();
         this.a(thien_as.T(), null, null, new thien_ab(thien_as.ae(), new thien_du(this)));
      }
   }

   public final void e() {
      if (this.X == null) {
         this.X = new thien_eh();
      }

      this.X.b((String[]) null);
      this.b(this.X);
      this.d(this.X);
      this.X.a(-1);
      this.c(this.l);
   }

   public static void f() {
      try {
         if (ay == null) {
            ay = Image.createImage("/GBg.png");
            return;
         }
      } catch (IOException var0) {
      }
   }

   public final void a(Graphics var1) {
      var1.setColor(0);
      var1.fillRect(0, 0, this.U, this.V);
      thien_di var2 = this;
      if (thien_w.a) {
         var1.drawImage(v, 0, 0, 20);
      } else {
         int var5 = g >> 1;
         var1.setColor(1404853);
         var1.fillRect(0, 0, thien_an.e, var5);
         var1.setColor(1334695);
         var1.fillRect(0, var5 + 0, thien_an.e, var5);
         var1.setColor(537185);
         var1.fillRect(0, 2 * var5, thien_an.e, 1);
         var1.setColor(6796786);
         var1.fillRect(0, 1, thien_an.e, 1);
      }

      var1.setColor(16777215);
      thien_w var10000 = thien_w.a(thien_w.d);
      int var10002 = thien_an.e >> 1;
      int var10003 = thien_w.a ? 1 : O + 1;
      var10000.a(((thien_an)this.L.elementAt(this.W)).i, var10002, var10003, 2, var1, thien_w.j, thien_w.f);
      if (this.aE > 1) {
         for (int var4 = 0; var4 < var2.aE; var4++) {
            if (((thien_an)var2.L.elementAt(var4)).t) {
               if (var4 < var2.W) {
                  if (var2.aF++ > 20) {
                     var2.aF = 0;
                  }
               } else if (var2.aG++ > 20) {
                  var2.aG = 0;
               }
            }
         }

         if (var2.W > 0 && var2.aF < 10) {
            var1.drawImage(thien_b.b[2], 4, var2.S, 20);
         }

         if (var2.W < var2.aE - 1 && var2.aG < 10) {
            var1.drawImage(thien_b.b[3], var2.U - 10, var2.S, 20);
         }
      }

      if (this.aD.u) {
         var1.setClip(0, g + 1, this.U, this.V);
         var1.setColor(396304);
         var1.fillRect(0, 0, this.U, this.V);
         int var30 = this.U - 248 >> 1;
         int var3 = this.V - 248 >> 1;
         int var11 = var30;
         var1.drawImage(ay, var11, var3, 20);
         var1.drawRegion(ay, 0, 0, 124, 248, 2, var11 + 124, var3, 20);
      } else {
         var1.setClip(0, g, this.U, this.V);
         var1.drawImage(ax, 0, this.R, 0);
      }

      if (this.aD.n) {
         var1.translate(-this.aD.o, 0);
      }

      this.aD.a(var1);
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      Graphics var15 = var1;
      var2 = this;

      for (int var19 = 0; var19 < 3; var19++) {
         if (var2.Z[var19] != 0) {
            var15.setClip(0, var2.ad[var19], thien_d.j, var2.ae[var19] + 2);
            var15.setColor(872315);
            var15.fillRect(var2.ac[var19] + 1, var2.af[var19] + 1, var2.ab[var19] - 1, var2.ae[var19] - 1);
            var15.setColor(14545919);
            thien_v.a(var15, var2.ac[var19], var2.af[var19], var2.ab[var19], var2.ae[var19]);
            int var24 = 5;
            if (var2.ah[var19] != null) {
               var15.drawImage(var2.ah[var19], var2.ac[var19] + 7 + (var2.ah[var19].getWidth() >> 1), var2.af[var19] + (var2.ae[var19] >> 1), 3);
               var24 = 5 + var2.ah[var19].getWidth() + 1;
            }

            var15.setColor(16777215);
            thien_w.a(thien_w.d).a(var2.aa[var19], var2.ac[var19] + 3 + var24, var2.af[var19] + 3, var15);
         }
      }

      var1.setClip(-1000, -1000, 2000, 2000);
      if (this.Y) {
         ((thien_ad)this.n.elementAt(0)).a(var1);
      } else if (this.ai) {
         var15 = var1;
         var2 = this;
         int var20 = 0;
         int var25 = this.aj.size();

         for (int var6 = 0; var6 < var25; var6++) {
            thien_am var7 = (thien_am)var2.aj.elementAt(var6);
            var20 = var2.aH ? thien_b.c(var7.d + var7.f - var7.h) : thien_b.c(var7.f - (var7.d - var7.h));
            var15.setClip((var2.aH ? var7.h : var7.d) + 2, var7.i + 2, var20 - 3, var7.g - 3);
            int var8 = var7.f / 50 + 1;

            while (--var8 >= 0) {
               int var9 = var7.g / 50 + 1;

               while (--var9 >= 0) {
                  var15.drawImage(w, (var2.aH ? var7.h : var7.d) + var8 * 50, var7.i + var9 * 50, 0);
               }
            }

            var15.drawImage(x, (var2.aH ? var7.h : var7.d) + (var7.f >> 1), var7.i, 17);
            var15.setClip(var7.d, var7.e, var7.f + 1, var7.g + 1);
            var15.setColor(14545919);
            thien_v.a(
               var15,
               (var2.aH ? var7.h : var7.d) + 1,
               var7.i + 1,
               (var2.aH ? thien_b.c(var7.d + var7.f - var7.h) : thien_b.c(var7.f - (var7.d - var7.h))) - 2,
               var7.g - 2
            );
            var15.setClip(var2.aH ? var7.d : var7.d + 2, var7.e, var2.aH ? var7.f - 1 : var7.f, var7.g);
            var15.translate(var7.h + 5, var7.i + 5);
            var8 = var7.a.size();

            for (int var27 = 0; var27 < var8; var27++) {
               var20 = 2 + var27 * var2.M + (thien_w.a ? 0 : 1);
               String var10 = ((thien_ab)var7.a.elementAt(var27)).a;
               if (((thien_ab)var7.a.elementAt(var27)).c != null) {
                  var10 = var10 + " >";
               }

               if (var27 == var7.c) {
                  var15.setColor(10278388);
                  var15.fillRoundRect(0, var27 * var2.M, (var2.aH ? thien_b.c(var7.d + var7.f - var7.h) : var7.f) - 9, var2.M + 1, 5, 5);
                  var15.setColor(0);
                  thien_w.a(thien_w.c).a(var10, 3, var20, var15);
               } else {
                  var15.setColor(16777215);
                  thien_w.a(thien_w.d).a(var10, 3, var20, var15);
               }
            }

            var15.translate(-(var7.h + 5), -(var7.i + 5));
         }

         var15.setClip(-1000, -1000, 5000, 5000);
         thien_an.c(var15);
         var15.setColor(16777215);
         var20 = thien_d.k - (g >> 1) - (thien_w.f >> 1) + (thien_w.a ? 0 : 1);
         thien_w.a(thien_w.d).a(thien_as.P(), 4, var20, var15);
         thien_w.a(thien_w.d).a(thien_as.z(), var2.U - 4, var20, 1, var15, thien_w.j, thien_w.f);
      } else if (this.ao) {
         this.b(var1);
      }

      if (this.ak) {
         int var14 = g + 2;
         int var17 = thien_w.a ? 0 : 1;
         var1.setColor(16777215);
         var1.fillRect(10, var14 + var17, thien_d.j - 20, thien_d.k - (var14 << 1));
         var1.setColor(0);
         var1.drawRect(10, var14 + var17, thien_d.j - 20, thien_d.k - (var14 << 1));
         var1.setClip(11, 11, thien_d.j - 22, thien_d.k - 22);
         if (this.al != null) {
            var1.drawImage(this.al, thien_d.j - this.al.getWidth() >> 1, var14 + 6, 0);
            var14 += this.al.getHeight() + thien_w.f + var17;
         }

         for (int var18 = 0; var18 < this.am.length; var18++) {
            thien_w.a(thien_w.e).a(this.am[var18], thien_d.j >> 1, var14 + var18 * thien_w.f, 2, var1, thien_w.j, thien_w.f);
         }
      }

      var1.setClip(-1000, -1000, 2000, 2000);
   }

   public final void g() {
      this.A = false;
      thien_ba.S = null;
      thien_ff.e();
      this.F();
      this.b(this.l);
      this.l.a(-1);
      this.m.f();
      this.j.o();
      if (this.k != null) {
         this.k.g();
      }

      int var1 = thien_hc.g;
      int var2 = thien_hc.h;
      int var3 = thien_hc.h + var1;
      thien_hb var4 = new thien_hb(42, 2);
      thien_a.a(var3, var4);
      thien_hc.a(var4);
      if (var1 > 0) {
         var1 = var1 / 1024 + 1;
      }

      if (var2 > 0) {
         var2 = var2 / 1024 + 1;
      }

      this.a(new String[]{"Dung lượng internet", var1 + var2 + " Kb"});
      thien_hc.g = 0;
      thien_hc.h = 0;
      thien_hc.b();

      try {
         Thread.sleep(50L);
      } catch (InterruptedException var5) {
      }

      System.gc();
   }

   public final void h() {
      this.m.b(this.U - 30);
      this.b(this.m);
      this.c(this.j);
      this.j.x.a(true);
      this.j.x.y = this.j.x.j;
      this.d(this.m);
   }

   public final void i() {
      this.j.b(this.U - 30);
      this.c(this.m);
      this.b(this.j);
      this.j.x.a(false);
      this.j.x.y = this.j.x.i;
   }

   private thien_ae E() {
      if (this.aB == null) {
         this.aB = new thien_ea(this);
      }

      return this.aB;
   }

   private thien_ab m(String var1) {
      if (this.az == null) {
         this.az = new thien_ab("", this.E());
      }

      this.az.a = var1;
      return this.az;
   }

   public final thien_ad a(String var1) {
      return this.a(var1, null, this.m(thien_as.z()), null);
   }

   public final thien_ad a(String var1, thien_ae var2) {
      return this.a(thien_w.b(var1, thien_d.j - 30, thien_w.j), new thien_ab("OK", var2), new thien_ab("", var2), this.m(thien_as.z()));
   }

   public final void b(String var1, thien_ae var2) {
      this.a(var1, null, new thien_ab("OK", var2), null);
   }

   public final void b(String var1) {
      this.a(thien_w.b(var1, thien_d.j - 30, thien_w.j));
   }

   public final void a(String[] var1) {
      if (this.aA == null) {
         this.aA = new thien_ab("", this.E());
      }

      this.a(var1, this.aA, this.m("OK"), null);
   }

   public final void c(thien_an var1) {
      int var2 = this.L.size();

      while (--var2 >= 0) {
         if (this.L.elementAt(var2).equals(var1)) {
            if (var2 <= this.W) {
               this.W--;
               if (this.W < 0) {
                  this.W = 0;
               }
            }

            this.L.removeElementAt(var2);
            System.gc();
            this.aE = this.L.size();
         }
      }

      this.D();
   }

   private void F() {
      this.L.removeAllElements();
      this.W = 0;
      this.aE = 0;
      this.aD = null;
   }

   public final thien_an c(String var1) {
      int var2 = this.aE;

      while (--var2 >= 0) {
         if (((thien_an)this.L.elementAt(var2)).g.equals(var1)) {
            return (thien_an)this.L.elementAt(var2);
         }
      }

      return null;
   }

   private void c(boolean var1) {
      if (!var1 && this.aj.size() > 1) {
         this.aj.removeElementAt(this.aj.size() - 1);
      } else {
         this.aj.removeAllElements();
         this.ai = false;
      }
   }

   public final void a(thien_am var1, int var2) {
      if (!this.Y) {
         if (!this.ai) {
            this.aj.removeAllElements();
         }

         this.ai = true;
         var1.b = var2;
         byte var3;
         if (this.U > 300) {
            var3 = 0;
         } else if (this.U <= 300 && this.U >= 170) {
            var3 = 70;
         } else {
            var3 = 100;
         }

         int var4 = 0;
         int var5 = 0;
         if (this.aj.size() > 0) {
            thien_am var6;
            var4 = (var6 = (thien_am)this.aj.lastElement()).d;
            var5 = var6.e;
         }

         var1.g = 10 + var1.a.size() * this.M;
         var1.f = 126;
         if (this.aj.size() == 0) {
            if (var2 == 0) {
               this.aH = false;
               var1.d = 1;
            } else if (var2 == 1) {
               this.aH = true;
               var1.d = this.U - var1.f - 2;
            } else if (var2 == 2) {
               this.aH = false;
               var1.d = (this.U >> 1) - (var1.f >> 1);
            }

            var1.e = this.V - g - var1.g;
            var1.h = var1.d;
            var1.i = this.V - g;
         } else if (this.aj.size() > 0) {
            if (this.aH) {
               if (this.aj.size() > 1 && var4 - var1.f + var3 < 0) {
                  this.aH = false;
                  var1.d = var4 + 126 - var3;
               } else {
                  var1.d = var4 - var1.f + var3;
               }
            } else {
               if (this.aj.size() > 1 && var4 + 126 - var3 + var1.f > this.U) {
                  this.aH = true;
                  var1.d = var4 - var1.f + var3;
               } else {
                  var1.d = var4 + 126 - var3;
               }

               if (((thien_am)this.aj.firstElement()).b == 2) {
                  var1.d = (this.U >> 1) - (var1.f >> 1);
               }
            }

            if (var1.d < 0) {
               var1.d = 0;
            }

            thien_am var8 = (thien_am)this.aj.lastElement();
            if ((var2 = var5 + var8.c * this.M) + var1.g > this.V - g) {
               var1.e = this.V - g - var1.g;
            } else {
               var1.e = var2;
            }

            var1.i = var1.e;
            if (this.aH) {
               var1.h = var1.d + var1.f;
            } else {
               var1.h = var1.d - var1.f;
            }
         }

         var1.c = 0;
         this.aj.addElement(var1);
      }
   }

   public final void a(boolean[] var1, boolean[] var2, int[] var3) {
      this.h++;
      if (this.h >= 100000) {
         this.h = 0;
      }

      if (this.h % 500 == 0 && thien_hc.c) {
         thien_a.c();
      }

      if (this.i != null) {
         this.i.a();
         this.i = null;
      }

      if (z && ++aI == 270) {
         aI = 0;
         z = false;
      }

      thien_di var4 = this;
      if (this.ak) {
         this.an--;
         if (this.an <= 0) {
            this.ak = false;
         }
      }

      if (this.d != null) {
         for (int var5 = this.d.size() - 1; var5 >= 0; var5--) {
            thien_a var6;
            if ((var6 = (thien_a)var4.d.elementAt(var5)) != null) {
               if ((long)var4.h % var6.c == 0L) {
                  var6.e = true;
               }

               if (var6.e && var4.Z[1] == 0) {
                  var6.e = false;
                  var4.a(var6.a, var6.b, 1);
                  var4.ag[1] = (int)var6.d;
               }
            }
         }
      }

      var4 = this;

      for (int var18 = 0; var18 < 3; var18++) {
         if (var4.Z[var18] > 0) {
            if (var18 == 1) {
               var4.ac[var18] = var4.ac[var18] - var4.ag[var18];
               if (var4.ac[var18] < -var4.ab[var18]) {
                  var4.Z[var18] = 0;
               }
            } else if (var18 == 0) {
               if (var4.Z[var18] < var4.ae[var18]) {
                  if (var4.af[var18] > var4.ad[var18]) {
                     var4.af[var18]--;
                  }
               } else if (var4.Z[var18] > 100 - var4.ae[var18]) {
                  var4.af[var18]++;
               }

               var4.Z[var18]++;
               if (var4.Z[var18] > 100) {
                  var4.Z[var18] = 0;
               }
            } else if (var18 == 2) {
               if (var4.Z[var18] < var4.ae[var18]) {
                  if (var4.af[var18] < var4.ad[var18]) {
                     var4.af[var18]++;
                  }
               } else if (var4.Z[var18] > 100 - var4.ae[var18]) {
                  var4.af[var18]--;
               }

               var4.Z[var18]++;
               if (var4.Z[var18] > 100) {
                  var4.Z[var18] = 0;
               }
            }
         }
      }

      if (this.aj.size() > 0) {
         thien_am var19;
         if ((var19 = (thien_am)this.aj.lastElement()).i > var19.e) {
            int var28;
            if ((var28 = var19.i - var19.e >> 1) <= 0) {
               var28 = 1;
            }

            var19.i -= var28;
         }

         if (var19.h != var19.d) {
            int var29;
            if ((var29 = thien_b.c(var19.d - var19.h) >> 1) <= 0) {
               var29 = 1;
            }

            var19.h = var19.h + (this.aH ? -var29 : var29);
         }
      }

      if (this.av > this.as) {
         int var20;
         if ((var20 = this.av - this.as >> 1) <= 0) {
            var20 = 1;
         }

         this.av -= var20;
      }

      this.aD.c();
      if (thien_d.d) {
         if (thien_d.h > thien_d.k - g) {
            if (thien_d.g < thien_d.j / 3) {
               var1[17] = true;
            } else if (thien_d.g > 2 * thien_d.j / 3) {
               var1[18] = true;
            } else {
               var1[16] = true;
            }
         } else if (!this.Y) {
            if (this.ai) {
               thien_am var10 = (thien_am)this.aj.lastElement();
               if (thien_d.g >= var10.d && thien_d.g <= var10.d + var10.f && thien_d.h <= var10.e + var10.g && thien_d.h >= var10.e) {
                  int var22;
                  if ((var22 = (thien_d.h - var10.e) / this.M) < 0) {
                     var22 = 0;
                  }

                  if (var22 >= var10.a.size()) {
                     var22 = var10.a.size() - 1;
                  }

                  var10.c = var22;
                  var1[16] = true;
               } else {
                  this.c(false);
               }
            } else if (this.ao) {
               if (thien_d.g >= this.ar && thien_d.g <= this.ar + this.at && thien_d.h <= this.as + this.au && thien_d.h >= this.as) {
                  int var9 = (thien_d.g - this.ar - 5) / 18;
                  int var21 = (thien_d.h - this.as - 5) / 18;
                  if (var9 < 0) {
                     var9 = 0;
                  }

                  if (var9 > 5) {
                     var9 = 5;
                  }

                  if (var21 < 0) {
                     var21 = 0;
                  }

                  if (var21 > 6) {
                     var21 = 6;
                  }

                  if (var9 == this.ap && var21 == this.aq) {
                     var1[16] = true;
                  } else {
                     this.ap = var9;
                     this.aq = var21;
                  }
               } else {
                  this.ao = false;
               }
            } else if (thien_d.h <= 0 || thien_d.h >= g) {
               this.aD.a(thien_d.g, thien_d.h - thien_an.d);
            } else if (thien_d.g < Q) {
               this.H();
               var1[14] = false;
            } else if (thien_d.g > thien_d.j - Q) {
               this.G();
               var1[15] = false;
            }
         }

         thien_d.d = false;
      }

      if (thien_d.e && !this.Y) {
         this.aD.c(thien_d.g, thien_d.h - thien_an.d);
         thien_d.e = false;
      }

      if (thien_d.c && !this.Y) {
         this.aD.b(thien_d.g, thien_d.h - thien_an.d);
      }

      if (thien_d.f && !this.Y) {
         this.aD.d(thien_d.g, thien_d.h - thien_an.d);
         thien_d.f = false;
      }

      if (this.Y) {
         thien_ad var17 = (thien_ad)this.n.elementAt(0);
         if (var1[17] && var17.a != null) {
            var17.a.b.a();
         }

         if (var1[18] && var17.c != null) {
            var17.c.b.a();
         }

         if (var1[16] && var17.b != null) {
            var17.b.b.a();
         }

         thien_d.b();
      } else if (this.ai) {
         if (var1[12] || var2[12]) {
            thien_am var16;
            (var16 = (thien_am)this.aj.lastElement()).c--;
            if (var16.c < 0) {
               var16.c = var16.a.size() - 1;
            }
         } else if (var1[13] || var2[13]) {
            thien_am var15;
            (var15 = (thien_am)this.aj.lastElement()).c++;
            if (var15.c > var15.a.size() - 1) {
               var15.c = 0;
            }
         } else if (var1[14]) {
            this.c(false);
         } else if (var1[15]) {
            thien_am var13;
            thien_ab var26;
            if ((var26 = (thien_ab)(var13 = (thien_am)this.aj.lastElement()).a.elementAt(var13.c)).c != null) {
               this.a(var26.c, -1);
            }
         } else if (var1[16] || var1[17]) {
            thien_am var14;
            thien_ab var27;
            if ((var27 = (thien_ab)(var14 = (thien_am)this.aj.lastElement()).a.elementAt(var14.c)).c == null) {
               if (var27.b != null) {
                  var27.b.a();
                  this.c(true);
               }
            } else {
               this.a(var27.c, -1);
            }
         } else if (var1[18]) {
            this.c(true);
         }

         thien_d.b();
      } else if (!this.ao) {
         boolean var12 = var1[14];
         boolean var25 = var1[15];
         this.aD.a = false;
         if (this.aD.a(var1, var2, var3)) {
            if (var12) {
               var1[14] = false;
               this.H();
               return;
            }

            if (var25) {
               var1[15] = false;
               this.G();
            }
         }
      } else {
         if (var1[17] || var1[16]) {
            this.ao = false;

            try {
               thien_an var11 = this.aD;
               if (this.aD == thien_ba.S && thien_ba.x) {
                  String var23 = thien_w.g[this.aq * 6 + this.ap];
                  if (thien_ba.ah == 1) {
                     thien_a.a(1, thien_ba.B, thien_ff.y, var23);
                  }
               }

               if (c(var11.s)) {
                  ((thien_at)var11.c(2)).b(thien_w.g[this.aq * 6 + this.ap]);
               } else {
                  thien_ew var24;
                  (var24 = (thien_ew)this.aD).A.b(thien_w.g[this.aq * 6 + this.ap]);
               }
            } catch (Exception var7) {
            }
         }

         if (var1[18]) {
            this.ao = false;
         }

         if (var1[12] || var2[12]) {
            this.d(true);
         }

         if (var1[13] || var2[13]) {
            this.aq++;
            if (this.aq > 6) {
               this.aq = 0;
               this.e(false);
            }
         }

         if (var1[14] || var2[14]) {
            this.ap--;
            if (this.ap < 0) {
               this.ap = 5;
               this.d(false);
            }
         }

         if (var1[15] || var2[15]) {
            this.e(true);
         }

         thien_d.b();
      }
   }

   private void d(boolean var1) {
      this.aq--;
      if (this.aq < 0) {
         this.aq = 6;
         if (var1) {
            this.ap--;
            if (this.ap < 0) {
               this.ap = 5;
            }
         }
      }
   }

   private void e(boolean var1) {
      this.ap++;
      if (this.ap > 5) {
         this.ap = 0;
         if (var1) {
            this.aq++;
            if (this.aq > 6) {
               this.aq = 0;
            }
         }
      }
   }

   private void G() {
      if (this.aE > 1) {
         this.W++;
         if (this.W >= this.aE) {
            this.W = 0;
         }

         this.D();
         this.aD.a(1);
      }
   }

   private void H() {
      if (this.aE > 1) {
         this.W--;
         if (this.W < 0) {
            this.W = this.aE - 1;
         }

         this.D();
         this.aD.a(-1);
      }
   }

   private void e(int var1) {
      this.W = var1;
      this.D();
   }

   public final void j() {
      this.e(this.aE - 1);
   }

   public final void k() {
      this.e(0);
   }

   public static void l() {
      c.d(c.j);
   }

   public final void d(String var1) {
      int var2 = this.aE;

      do {
         var2--;
      } while (var2 >= 0 && !((thien_an)this.L.elementAt(var2)).g.equals(var1));

      this.W = var2;
      this.D();
   }

   public final void d(thien_an var1) {
      if (var1 == null) {
         this.e(0);
      } else {
         int var2 = this.aE;

         do {
            var2--;
         } while (var2 >= 0 && !((thien_an)this.L.elementAt(var2)).equals(var1));

         if (var2 == -1) {
            this.e(0);
         } else {
            this.W = var2;
            this.D();
         }
      }
   }

   private boolean f(thien_an var1) {
      int var2 = this.aE;

      while (--var2 >= 0) {
         if (((thien_an)this.L.elementAt(var2)).equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public static int a(byte var0, byte var1, byte var2, byte var3) {
      return var0 << 24 & 0xFF000000 | var1 << 16 & 0xFF0000 | var2 << 8 & 0xFF00 | var3 & 0xFF;
   }

   private static byte[] f(int var0) {
      byte[] var1;
      (var1 = new byte[4])[0] = (byte)(var0 >> 24);
      var1[1] = (byte)(var0 >> 16 & 0xFF);
      var1[2] = (byte)(var0 >> 8 & 0xFF);
      var1[3] = (byte)var0;
      return var1;
   }

   private static void a(ByteArrayOutputStream var0, String var1) throws IOException {
      var0.write(var1.getBytes());
      var0.write(aJ);
   }

   private static void a(ByteArrayOutputStream var0, int var1) throws IOException {
      var0.write(f(var1));
   }

   private static int a(ByteArrayInputStream var0) {
      return a((byte)var0.read(), (byte)var0.read(), (byte)var0.read(), (byte)var0.read());
   }

   private static String b(ByteArrayInputStream var0) {
      String var1 = "";

      int var2;
      while ((var2 = var0.read()) != 0) {
         var1 = var1 + (char)((byte)var2);
      }

      return var1;
   }

   private static void a(int var0, boolean var1) {
      Xuka.a(var1 ? "yahoocs" : "vitalkcs", f(var0));
   }

   public static int a(boolean var0) {
      return Xuka.i(var0 ? "yahoocs" : "vitalkcs");
   }

   private static boolean a(thien_s var0, boolean var1, String var2) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Vector var9 = var0.a;

      try {
         a(var3, var9.size());

         for (int var4 = 0; var4 < var9.size(); var4++) {
            thien_t var5 = (thien_t)var9.elementAt(var4);
            a(var3, var5.a());
            Vector var10 = var5.a;
            a(var3, var10.size());

            for (int var6 = 0; var6 < var10.size(); var6++) {
               thien_r var7 = (thien_r)var10.elementAt(var6);
               a(var3, var7.a);
               a(var3, var7.b);
               a(var3, var7.h);
            }
         }

         Xuka.a((var1 ? "ybuddy" : "vbuddy") + var2, var3.toByteArray());
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   public static thien_s a(boolean var0, String var1) {
      byte[] var9;
      if ((var9 = Xuka.b((var0 ? "ybuddy" : "vbuddy") + var1)) == null) {
         return null;
      } else {
         ByteArrayInputStream var10 = new ByteArrayInputStream(var9);
         thien_s var11 = new thien_s();

         try {
            var11.a = new Vector();
            int var2 = a(var10);

            for (int var3 = 0; var3 < var2; var3++) {
               thien_t var4;
               (var4 = new thien_t(b(var10))).a = new Vector();
               int var5 = a(var10);

               for (int var6 = 0; var6 < var5; var6++) {
                  thien_r var7;
                  (var7 = new thien_r()).a = b(var10);
                  var7.b = b(var10);
                  var7.h = a(var10);
                  var4.a(var7);
               }

               var11.a.addElement(var4);
            }

            return var11;
         } catch (Exception var8) {
            return null;
         }
      }
   }

   public final void a(String var1, String var2, String var3) {
      String var4 = "Y! " + var1;
      thien_ew var5;
      if ((var5 = (thien_ew)this.c(var4)) == null) {
         (var5 = new thien_ew(var4, true, false, null)).y = var1;
         var5.x = var1;
         this.b(var5);
      }

      if (!var5.g.equals(this.aD.g)) {
         this.a();
      }

      var5.z.a(var1 + " (" + var3 + ")", var2, 1);
      var5.z.b();
      var5.a = true;
   }

   public final void b(String var1, String var2, String var3) {
      if (!n(var1)) {
         thien_ew var4;
         if (!(var4 = this.e(var1)).g.equals(this.aD.g)) {
            this.a();
         }

         var4.z.a(var4.y + " (" + var3 + ")", var2, 1);
         var4.z.b();
         var4.a = true;
      }
   }

   public final thien_ew e(String var1) {
      thien_ew var2;
      if ((var2 = (thien_ew)this.c(var1)) == null) {
         thien_u var3;
         if ((var3 = this.j.x.e(var1)) == null) {
            var2 = new thien_ew(var1, false, false, null);
         } else {
            (var2 = new thien_ew(var1, false, false, var3.j)).b(Integer.toString(var3.i.i));
         }

         if (var3 != null && var3.e != null && !var3.e.equals("")) {
            var2.y = var3.e;
         } else {
            var2.y = var1;
         }

         this.b(var2);
      }

      return var2;
   }

   public final void a(String var1, String var2) {
      if (!n(var1)) {
         thien_ew var3;
         if (!(var3 = this.e(var1)).g.equals(this.aD.g)) {
            String var4 = thien_w.a(var2, thien_d.j - thien_d.j / 3, thien_w.j);
            this.a(var1 + " chat: " + var4 + "...", (Image) null, 1);
            var3.t = true;
            this.a();
         }

         boolean var5 = var3.z.a();
         var3.z.a(var3.y, var2, 1);
         if (var5) {
            var3.z.b();
         }

         var3.a = true;
      }
   }

   public final void b(String var1, String var2) {
      String var3 = "Y! " + var1;
      thien_ew var4;
      if ((var4 = (thien_ew)this.c(var3)) == null) {
         (var4 = new thien_ew(var3, true, false, null)).y = var1;
         var4.x = var1;
         this.b(var4);
      }

      if (!var4.g.equals(this.aD.g)) {
         var3 = thien_w.a(var2, thien_d.j - thien_d.j / 3, thien_w.j);
         this.a(var1 + " chat: " + var3 + "...", (Image)null, 1);
         var4.t = true;
         this.a();
      }

      boolean var6 = var4.z.a();
      var4.z.a(var1, var2, 1);
      if (var6) {
         var4.z.b();
      }

      var4.a = true;
   }

   public final void m() {
      this.c();
      this.a(thien_as.Q(), null, new thien_ab("OK", new thien_eb(this)), null);
   }

   public final void n() {
      this.c();
      this.l.D.a(this.X.G);
      this.l.E.a(this.X.F);
      Xuka.f(this.X.G);
      Xuka.c(this.X.F);
      this.b(this.l);
      this.l.c(this.l.D);
      this.c(this.X);
   }

   public final void o() {
      this.c();
      this.b(thien_as.S());
   }

   public final void p() {
      this.aK = true;
      if (thien_d.i == 1) {
         this.c();
         this.a(thien_as.T(), null, null, new thien_ab(thien_as.ae(), new thien_ec(this)));
      }
   }

   public final void a(String var1, String var2, int var3) {
      var2 = thien_fe.b(var2);
      switch (var3) {
         case 1:
            if (this.j.x != null) {
               this.j.x.a(var1, var2, 1);
               return;
            }
            break;
         case 2:
            try {
               this.k.w.a(var1, var2, 1);
               return;
            } catch (Exception var4) {
            }
      }
   }

   public final void a(String var1, int var2, int var3) {
      switch (var3) {
         case 1:
            if (this.j.x.a(var1, var2)) {
               String var9 = var2 == 1 ? thien_as.az() : thien_as.aA();
               int var11 = this.aD instanceof thien_ew ? 2 : 0;
               this.a(var1 + var9, var2 == 1 ? thien_b.a[1] : thien_b.a[0], var11);

               try {
                  thien_ew var12;
                  if ((var12 = (thien_ew)this.c(var1)) != null) {
                     var12.z.a(var1 + var9, var2 == 1 ? 1 : 2);
                     var12.z.b();
                     return;
                  }
               } catch (Exception var7) {
                  return;
               }
            }
            break;
         case 2:
            try {
               if (this.k != null && this.k.w != null && this.k.w.a(var1, var2)) {
                  String var8 = var2 == 1 ? thien_as.az() : thien_as.aA();
                  int var4 = this.aD instanceof thien_ew ? 2 : 0;
                  this.a("Y! " + var1 + var8, var2 == 1 ? thien_b.a[1] : thien_b.a[0], var4);

                  try {
                     thien_ew var10;
                     if ((var10 = (thien_ew)this.c("Y! " + var1)) != null) {
                        var10.z.a(var1 + var8, var2 == 1 ? 1 : 2);
                        var10.z.b();
                        return;
                     }
                  } catch (Exception var5) {
                     return;
                  }
               }
            } catch (Exception var6) {
            }
      }
   }

   public final void f(String var1) {
      this.b(var1);
   }

   public final void q() {
      thien_ba.S = null;
      this.F();
      this.b(this.l);
      this.c();
      this.a(thien_as.U(), (Image)null, 0);
   }

   public final void g(String var1) {
      this.b(thien_as.V() + var1);
   }

   public final void h(String var1) {
      this.b(var1 + thien_as.W());
   }

   public final void a(int var1, thien_r var2, String var3) {
      this.j.x.k.a(var3, var2);
      this.j.x.c();
      thien_b.d();
      a(this.j.x.k, false, thien_ff.y);
      a(var1, false);
   }

   public final void a(String var1, int var2, String var3, String var4, int var5) {
      this.j.x.a(var1, var4, 2);
      this.j.x.a(var1, var2);
      this.j.x.a(var1, var3, 1);
      a(var5, false);
      this.b(thien_as.X() + var1 + thien_as.Y());
   }

   public final void r() {
      this.b(thien_as.al());
   }

   public final void c(String var1, String var2) {
      this.c();
      this.m.w = var1;
      this.m.x = var2;
      this.h();
   }

   public final void a(String var1, String[] var2, String var3) {
      var3 = var3 + " " + var1;
      thien_ew var4;
      (var4 = new thien_ew(var3, false, true, null)).h = var1;
      int var5 = this.aE;

      while (--var5 >= 0) {
         thien_an var6;
         if ((var6 = (thien_an)this.L.elementAt(var5)).h == var1) {
            var4 = (thien_ew)var6;
         }
      }

      if (var2 != null) {
         this.aC = var2.length;

         for (int var8 = 0; var8 < this.aC; var8++) {
            var4.z.a(thien_as.at() + var2[var8] + "...", 1);
         }

         var4.z.b();
      }

      this.b(var4);
      this.d(var3);
   }

   public final void c(String var1, String var2, String var3) {
      if (!n(var1)) {
         this.a(
            new String[]{var1 + thien_as.am(), var3},
            new thien_ab(thien_as.z(), new thien_ed(this)),
            new thien_ab("OK", new thien_ee(this, var2, var1, var3)),
            new thien_ab(thien_as.z(), new thien_ef(this, var2, var1))
         );
      }
   }

   public final void d(String var1, String var2) {
      int var3 = this.aE;

      while (--var3 >= 0) {
         thien_an var4;
         if ((var4 = (thien_an)this.L.elementAt(var3)).h.equals(var2)) {
            thien_ew var5;
            (var5 = (thien_ew)var4).z.a(var1 + thien_as.ao(), 2);
            var5.z.b();
         }
      }
   }

   public final void e(String var1, String var2) {
      int var3 = this.aE;

      while (--var3 >= 0) {
         thien_an var4;
         if ((var4 = (thien_an)this.L.elementAt(var3)).h.equals(var2)) {
            thien_ew var5;
            (var5 = (thien_ew)var4).z.a(var1 + thien_as.aq(), 2);
            var5.z.b();
         }
      }
   }

   public final void f(String var1, String var2) {
      int var3 = this.aE;

      while (--var3 >= 0) {
         thien_an var4;
         if ((var4 = (thien_an)this.L.elementAt(var3)).h.equals(var2)) {
            thien_ew var5;
            (var5 = (thien_ew)var4).z.a(var1 + thien_as.ap(), 2);
            var5.z.b();
         }
      }
   }

   public final void d(String var1, String var2, String var3) {
      if (var1.equals(this.B)) {
         this.C++;
         if (this.C > 3) {
            return;
         }
      } else {
         this.B = var1;
         this.C = 0;
      }

      int var4 = this.aE;

      while (--var4 >= 0) {
         thien_an var5;
         if ((var5 = (thien_an)this.L.elementAt(var4)).h.equals(var2)) {
            thien_ew var6 = (thien_ew)var5;
            if (var3.length() > 100) {
               var3 = var3.substring(0, 99) + "...";
            }

            var6.z.a(var1, var3, 1);
            var6.z.b();
            var6.a = true;
         }
      }
   }

   public final void a(String var1, String[] var2) {
      int var3 = this.aE;

      while (--var3 >= 0) {
         thien_an var4;
         if ((var4 = (thien_an)this.L.elementAt(var3)).h.equals(var1)) {
            thien_ew var5 = (thien_ew)var4;
            this.aC = var2.length;

            for (int var6 = 0; var6 < this.aC; var6++) {
               var5.z.a(var2[var6] + thien_as.ao(), 1);
            }

            var5.z.b();
            return;
         }
      }
   }

   public final void s() {
      this.k.C = false;
      this.k.a(false);
      this.a(thien_as.aw(), (Image)null, 0);
   }

   public final void t() {
      this.k.a(false);
      this.b(thien_as.ax());
   }

   public final void i(String var1) {
      this.b(var1, thien_as.b[0]);
      this.a();
   }

   public final thien_an u() {
      return this.aD;
   }

   public final void j(String var1) {
      this.a(var1, thien_as.s());
      this.a();
   }

   public final void g(String var1, String var2) {
      this.a(thien_as.aB() + var1, new thien_ab(thien_as.aC(), new thien_eg(this, var2)), null, new thien_ab(thien_as.z(), new thien_dk(this)));
   }

   public final String v() {
      return this.J == null ? K : this.J;
   }

   public final String w() {
      return this.I == null ? K : this.I;
   }

   public final void e(String var1, String var2, String var3) {
      this.c();
      this.J = var2;
      thien_dl var4 = new thien_dl(this);
      thien_dm var5 = new thien_dm(this, var3, var4);
      String var7 = var3 + Xuka.f;
      this.a(
         thien_w.b(var1 + thien_as.R() + var7 + " => " + var2.substring(6), thien_d.j - 30, thien_w.j),
         new thien_ab("OK", var5),
         null,
         new thien_ab(thien_as.z(), var4)
      );
   }

   public final void h(String var1, String var2) {
      this.I = var1;
      D = var2;
      if (this.l != null) {
         this.l.g();
      }
   }

   public final void a(String var1, byte var2, String var3, int var4, int var5) {
      thien_ff.z = var1;
      if (!var1.equals("")) {
         thien_ff.A = thien_ff.z;
      }

      thien_ff.F = var2;
      thien_ff.G = var3;
      thien_ff.H = var4;
      thien_ff.E = Integer.toString(var5);
      thien_ew.e();
   }

   private static boolean n(String var0) {
      int var1 = t.size();

      while (--var1 >= 0) {
         if (((String)t.elementAt(var1)).equals(var0)) {
            return true;
         }
      }

      return false;
   }

   public final void x() {
      if (G != null && this.f(G)) {
         G.a(1);
         this.d(G);
      } else {
         thien_a.a();
      }
   }

   public final void y() {
      this.I();
      if (this.f(this.k)) {
         this.d(this.k);
      } else {
         this.k.a(false);
         this.b(this.k);
         this.d(this.k);
      }
   }

   private void I() {
      if (this.k == null) {
         this.k = new thien_gp();
      }

      this.k.a(1);
   }

   public final void z() {
      String var2;
      if ((var2 = Xuka.c(thien_ff.y, false)) != null) {
         thien_ff.D = var2;
         if (thien_ff.B == 1) {
            thien_a.a(thien_ff.D, 1);
         }
      } else {
         thien_ff.D = "";
      }

      if (thien_ff.D.length() > 0) {
         thien_a.a(thien_ff.D, 1);
      }

      t.removeAllElements();
      thien_a.d();
      int var1 = thien_as.a;
      thien_hb var3 = new thien_hb(59, 14);
      thien_a.a(var1, var3);
      thien_hc.a(var3);
      this.A();
   }

   public final void A() {
      this.c();
      if (this.F == null) {
         this.F = new thien_ca();
      }

      this.b(this.F);
      this.c(this.l);
      if (s) {
         this.I();
         this.k.a(false);
         this.b(this.k);
         this.k.f();
      }

      thien_aq.b();
   }

   public final void a(thien_s var1, int var2) {
      a(var2, false);
      a(var1, false, thien_ff.y);
      this.j.x.m = thien_w.b(thien_as.aX(), thien_d.j - 40, thien_w.j);
      this.j.x.a(var1, -1);
      this.c();
   }

   public final void b(int var1) {
      a(var1, true);
   }

   public final void B() {
      if (thien_gp.z == 0 && thien_gp.A != null && thien_gp.A.length() > 0) {
         thien_a.a(thien_gp.A, 2);
      }

      this.k.C = true;
      this.k.a(true);
      if (Xuka.g(thien_gp.x) == 0) {
         this.k.h();
      }
   }

   public final void a(thien_s var1) {
      a(var1, true, thien_gp.x);
      this.k.w.a(var1, -1);
      this.k.a = true;
      this.k.w.e = false;
   }

   public final void k(String var1) {
      thien_ap var2;
      (var2 = new thien_ap()).g = thien_as.y();
      thien_y.a(var2, var1 + thien_as.be());
      thien_at var3 = thien_y.a(var2, thien_as.x(), 0);
      thien_z var4;
      (var4 = thien_y.a(var2, thien_as.aI(), this.j.x.i())).a(new thien_dq(this, var4, var3));
      if (var4.a != null && var4.a.length != 0) {
         var3.a(var4.b());
      } else {
         var3.a("Friends");
      }

      var2.k = new thien_ab(thien_as.z(), new thien_dr(this, var3, var1, var2));
      var2.m = new thien_ab("OK", new thien_ds(this, var3, var1, var2));
      var2.l = new thien_ab(thien_as.ae(), new thien_dt(this, var2));
      var2.c((thien_ac)var2.j.elementAt(0));
      this.e(var2);
   }

   public final void a(Vector var1) {
      thien_an var2;
      (var2 = new thien_an()).g = thien_as.bj();
      int var3;
      if ((var3 = thien_d.j - 30) > 150) {
         var3 = 180;
      }

      if (var3 < 100) {
         var3 = 100;
      }

      int var4 = thien_d.j - var3 >> 1;
      thien_ai var6 = new thien_ai(thien_as.bj(), var4, 10, thien_w.f);
      int var5 = 10 + 1 + var6.t;
      String[] var7;
      if (var1.size() == 0) {
         (var7 = new String[1])[0] = "---";
      } else {
         var7 = new String[var1.size()];

         for (int var8 = 0; var8 < var1.size(); var8++) {
            var7[var8] = (String)var1.elementAt(var8);
         }
      }

      thien_z var16 = new thien_z(var7, var4, var5, var3, thien_w.f + 6);
      var5 += 8 + var16.t;
      thien_ai var9 = new thien_ai(thien_as.bk(), var4, var5, thien_w.f);
      var5 += 3 + var6.t;
      thien_at var15;
      (var15 = new thien_at()).a(var4, var5, var3, thien_w.f + 6);
      var5 += 10 + var15.t;
      thien_v var10 = new thien_v(thien_as.v() + "/" + thien_as.ag(), var4, var5, var3, thien_w.f + 6);
      var16.b = new thien_dv(this, var16, var15);
      String var11;
      if (!(var11 = var16.b()).equals("---")) {
         var15.a(var11);
      }

      var10.a = new thien_dw(this, var15, var2, var16);
      var2.a(var6);
      var2.a(var16);
      var2.a(var9);
      var2.a(var15);
      var2.a(var10);
      var2.c(var16);
      var2.k = new thien_ab(thien_as.z(), new thien_dx(this, var2));
      this.b(var2);
      this.j();
      this.c();
   }

   public final void b(boolean var1) {
      if (var1) {
         this.b(thien_as.bg());
      } else {
         this.b(thien_as.bh());
      }
   }

   public static boolean c(int var0) {
      return var0 == 2000 || var0 == 2002 || var0 == 2003 || var0 == 2001;
   }

   public final void a(int var1, String var2, byte[] var3, long var4, long var6, String var8) {
      try {
         if (var1 == 0) {
            if (var4 <= 0L) {
               var4 = 1L;
            }

            thien_a var10 = new thien_a(var1, var2, var3, var4 * 25L, var6, var8);
            this.d.addElement(var10);
            return;
         }

         if (var1 != 1) {
            if (var1 == 2) {
               E = var2;
               return;
            }

            if (var1 == 3) {
               this.ak = true;
               this.al = Image.createImage(var3, 0, var3.length);
               this.am = thien_w.b(var2, thien_d.j - 50, thien_w.j);
               this.an = (int)var6;
               return;
            }
         }
      } catch (Exception var9) {
      }
   }

   public final void l(String var1) {
      this.a(var1 + thien_as.br(), new thien_ab("OK", new thien_dy(this, var1)), null, new thien_ab(thien_as.z(), new thien_dz(this, var1)));
   }

   public final void a(String[] var1, int[] var2) {
      Xuka.a(var1);
      Xuka.a(var2);
      if (!Xuka.b("report", false)) {
         Xuka.a("report", true);
         if (Xuka.h == null) {
            Xuka.h = "null";
         }

         thien_a.a(0, Xuka.h, thien_d.k, Xuka.b);
      }

      thien_a.b();
   }

   public final thien_an d(int var1) {
      int var2 = this.aE;

      while (--var2 >= 0) {
         thien_an var3;
         if ((var3 = (thien_an)this.L.elementAt(var2)).s == var1) {
            return var3;
         }
      }

      return null;
   }

   public final void a(byte[] var1) {
      thien_a.a(var1);
   }

   public final void a(int var1, byte[] var2) {
      thien_ck.a(var1, var2);
   }

   public final void a(String var1, int[] var2) {
      if (var1.equals(thien_ff.y)) {
         thien_ff.w = var2;
      } else {
         int[] var3 = var2;
         String var9 = var1;
         thien_s var8 = this.j.x.k;

         for (int var4 = this.j.x.k.a.size() - 1; var4 >= 0; var4--) {
            thien_r var5;
            if ((var5 = ((thien_t)var8.a.elementAt(var4)).a(var9)) != null) {
               var5.f = var3;
            }
         }

         this.j.x.c();
      }
   }

   public final void a(String var1, int var2) {
      this.j.x.b(var1);
      a(this.j.x.k, false, thien_ff.y);
      a(var2, false);
      this.b(thien_as.an());
   }

   public final void a(int var1, String var2, String var3) {
      this.b(thien_as.aM());
      this.j.x.b(var2, var3);
      a(this.j.x.k, false, thien_ff.y);
      a(var1, false);
   }

   public final void b(int var1, String var2, String var3) {
      this.j.x.a(var2, var3);
      this.b(thien_as.aN());
      a(this.j.x.k, false, thien_ff.y);
      a(var1, false);
   }

   public final void b(String[] var1) {
      thien_an var2 = this.aD;
      if (this.aD != null && var2 instanceof thien_eh) {
         thien_eh var3;
         (var3 = (thien_eh)var2).b(var1);
      }
   }

   public final void a(
      String var1,
      String var2,
      int var3,
      byte[] var4,
      int var5,
      String[] var6,
      int[] var7,
      long[] var8,
      long[] var9,
      byte[][] var10,
      boolean[] var11,
      String[] var12,
      int[] var13,
      Integer[] var14
   ) {
      thien_ba.S.a(var2, var3, var4, null, false);
      thien_ba.S.N = var11;
      thien_ba.S.M = var7;
      thien_ba.S.a(var1, (byte)var6.length, var6, var8, var9, (byte)var6.length, var6, var10, var12, var13, var14);
   }

   public final void a(String var1, String var2, int var3, byte[] var4, String var5, boolean var6) {
      if (thien_ba.z.equals(var2)) {
         thien_ba.S.P.a(var4);
      }

      thien_ba.S.a(var2, var3, var4, var5, var6);
   }

   public final void a(String var1, String var2, int var3, byte[] var4, String var5, boolean var6, int var7) {
      this.a(var1, var2, var3, var4, var5, var6);

      for (int var8 = 0; var8 < thien_ba.S.F.length; var8++) {
         if (thien_ba.S.F[var8].a.equals(var2)) {
            thien_ba.S.F[var8].d = thien_as.h() + var7;
            thien_ba.S.F[var8].h = true;
         }
      }
   }

   public final void C() {
      thien_ba.S.P.a();
   }

   public final void a(String var1, String var2, String var3, String[] var4, int var5) {
      if (var2.equals(thien_ba.z)) {
         if (var5 == 1) {
            this.a(thien_as.f(), (Image)null, 1);
         }

         thien_ba.e();
      } else {
         if (var4.length > 0) {
            thien_ba.S.F = c(var4);
            thien_ba.S.w = var3;
            long[] var11 = new long[var4.length];
            int[] var6 = new int[var4.length];
            String[] var7 = new String[var4.length];
            int[] var8 = new int[var4.length];
            Integer[] var9 = new Integer[var4.length];
            thien_ba.S.O = new boolean[var4.length];

            for (int var10 = 0; var10 < var4.length; var10++) {
               var11[var10] = thien_ba.S.F[var10].b;
               var6[var10] = thien_ba.S.F[var10].c;
               thien_ba.S.O[var10] = thien_ba.S.F[var10].g;
               var7[var10] = thien_ba.S.F[var10].C;
               var8[var10] = thien_ba.S.F[var10].D;
               var9[var10] = thien_ba.S.F[var10].E;
               if (var4[var10].equals(var3)) {
                  thien_ba.S.b(var2);
               }
            }

            thien_ba.S.a((byte)var4.length, var4, var11, var6, var7, var8, var9, var1);
         }
      }
   }

   public final void a(String var1, String var2, String var3, boolean var4) {
      thien_ba.S.a(var2, var3, var4);
   }

   public final void a(String var1, long var2, String[] var4, long[] var5, int[] var6, boolean[] var7, String var8, String[] var9, int[] var10, Integer[] var11) {
      thien_ba var12 = thien_ba.S;
      thien_ba.S.Y = true;
      var12.Z = var4.length;
      var12.aa = var4;
      var12.ab = var5;
      var12.ac = var2;
      var12.ad = var6;
      var12.w = var8;
      var12.O = new boolean[var4.length];
      var12.ae = var9;
      var12.af = var10;
      var12.ag = var11;
      if (var12.X) {
         var12.K = (byte)var4.length;
         var12.C = var2;
         var12.G = new String[var4.length];
         var12.L = new int[var4.length];

         for (byte var13 = 0; var13 < var4.length; var13++) {
            var12.G[var13] = var4[var13];
            var12.L[var13] = var6[var13];
            var12.O[var13] = var7[var13];
         }

         this.c();
         var12.a((byte)var4.length, var4, var5, var6, var9, var10, var11, var1);
      }
   }

   public final void a(byte[] var1, String var2, boolean var3) {
      thien_ax.B = false;
      thien_ba.T = false;
      thien_ba.S.E = true;
      thien_ba.S.a(var1, var2, var3, true);
   }

   public final void a(String[] var1, boolean[] var2) {
      for (byte var3 = 0; var3 < thien_ba.S.F.length; var3++) {
         for (int var4 = 0; var4 < var1.length; var4++) {
            if (thien_ba.S.F[var3].a.equals(var1[var4])) {
               thien_ba.S.F[var3].g = var2[var4];
               break;
            }
         }
      }
   }

   public static thien_bz[] c(String[] var0) {
      thien_bz[] var1 = new thien_bz[var0.length];

      for (byte var2 = 0; var2 < var0.length; var2++) {
         for (byte var3 = 0; var3 < thien_ba.S.F.length; var3++) {
            if (var0[var2].equals(thien_ba.S.F[var3].a)) {
               var1[var2] = thien_ba.S.F[var3];
            }
         }
      }

      return var1;
   }

   public final void b(String var1, String var2, String var3, boolean var4) {
      thien_ba.S.b(var2, var3, var4);
   }

   public final void a(
      String var1, String var2, byte var3, String[] var4, int[] var5, long[] var6, long[] var7, byte[][] var8, String[] var9, int[] var10, Integer[] var11
   ) {
      thien_ba.S.N = new boolean[var4.length];

      for (int var12 = 0; var12 < var4.length; var12++) {
         thien_ba.S.N[var12] = false;
         if (var4[var12].equals(thien_ba.z)) {
            for (int var13 = 0; var13 < var4.length; var13++) {
               if (thien_ba.S.F[var13].a.equals(var4[var12])) {
                  thien_ba.S.F[var13].i = var8[var12];
                  thien_ba.S.a(var8[var12], var2, false, false);
                  break;
               }
            }
         }
      }

      thien_ba.S.M = var5;
      thien_ba.S.a(var1, var3, var4, var6, var7, var3, var4, var8, var9, var10, var11);
   }

   public final void a(long var1) {
      this.a(thien_as.bD() + var1 + " xuxu", (Image)null, 1);
   }

   public final void b(String var1, String var2, int var3) {
      if (var2.length() >= 5) {
         this.a(var1 + ": " + var2, (Image)null, 0);
      } else {
         int var4;
         if ((var4 = thien_w.a(var2)) != 100) {
            thien_bz[] var5 = null;
            if (var3 == 39) {
               var5 = thien_ba.S.F;
            }

            if (var5 != null) {
               var3 = 0;

               for (int var6 = var5.length; var3 < var6; var3++) {
                  if (var5[var3].a.equals(var1)) {
                     var5[var3].m = true;
                     var5[var3].B = var4;
                     var5[var3].n = (byte)((int)(System.currentTimeMillis() / 1000L));
                     return;
                  }
               }
            }

            this.a(var1 + ": " + var2, (Image)null, 0);
         } else {
            this.a(var1 + ": " + var2, (Image)null, 0);
         }
      }
   }

   public final void a(String var1, thien_aw[] var2, int var3, String var4) {
      if (thien_ba.S != null && !thien_ba.x) {
         this.c(thien_ba.S);
         thien_ba.S = null;
      }

      thien_ba var5 = thien_ba.d(1);
      if (this.L.contains(var5) && thien_ba.x) {
         this.b(thien_as.m());
      } else {
         thien_ba.ai = var1;
         thien_ba.S.g = var4;
         thien_ba.S.a(var4);
         thien_ba var6 = thien_ba.S;
         this.e(var6);
         thien_ba.S.a(var2, 1);
         this.d(thien_ba.S);
      }
   }

   public final void a(
      String var1,
      String var2,
      int[] var3,
      byte var4,
      String var5,
      int var6,
      byte var7,
      byte var8,
      byte var9,
      byte var10,
      int var11,
      int var12,
      String var13,
      int var14
   ) {
      Object var15 = null;
      Vector var18 = null;
      if (var14 == 1) {
         var18 = this.j.x.l;
      }

      var7 = (byte) var18.size();

      while (--var7 >= 0) {
         thien_u var16;
         if ((var16 = (thien_u)var18.elementAt(var7)).d.equals(var1)) {
            var16.e = var2;
            var16.j = var3;
            if (var14 == 2) {
               var16.f = var13;
            }

            thien_r var17;
            (var17 = var16.i).b = var2;
            var17.f = var3;
            var17.i = var6;
         }
      }

      if (var14 == 1) {
         thien_b.d();
      }
   }

   public final void a(String[] var1, int[] var2, String[] var3) {
      thien_s var4;
      int var5 = (var4 = this.j.x.b()).a.size();

      while (--var5 >= 0) {
         thien_t var6;
         int var7 = (var6 = (thien_t)var4.a.elementAt(var5)).a.size();

         while (--var7 >= 0) {
            thien_r var8 = (thien_r)var6.a.elementAt(var7);
            int var9 = var1.length;

            while (--var9 >= 0) {
               if (var8.a.equals(var1[var9])) {
                  if (var2 != null) {
                     var8.a(var2[var9]);
                     var8.d = var3[var9];
                  } else {
                     var8.c = 1;
                  }
                  break;
               }
            }
         }
      }

      this.j.x.a(var4, -1);
   }

   private static String g(int var0) {
      return "cs" + var0;
   }

   private static String h(int var0) {
      return "cs2" + var0;
   }

   public final void b(int var1, int var2) {
      byte[] var7;
      if (Xuka.i(g(var1)) == var2 && (var7 = Xuka.b(h(var1))) != null) {
         try {
            thien_a.a(var7);
            return;
         } catch (Exception var4) {
         }
      }

      boolean var5 = false;
      thien_hb var8 = new thien_hb(123, 2);
      thien_a.a(var1, var8);
      thien_hc.a(var8);
   }

   public final void a(int var1, int var2, byte[] var3) {
      thien_a.a(var3);
      Xuka.a(g(var1), f(var2));
      Xuka.a(h(var1), var3);
   }

   public final void b(thien_s var1) {
      if (G == null) {
         (G = new thien_em()).w.d = new thien_dp(this);
         G.w.b.a = "Vào phòng";
         G.g = "Tiến Lên Miền Nam";
         G.x = 0;
         G.a(G.g);
      }

      G.w.a(var1, 0);
      G.a(1);
      if (!this.f(G)) {
         this.b(G);
      }

      this.d(G);
   }
}
