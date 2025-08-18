package home.thienph.xyahoo;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_b extends UIControlBase {
   public static Image[] a;
   public static Image[] b;
   public boolean c;
   public boolean d;
   public boolean e;
   private String B;
   private boolean C;
   private int D;
   private int E;
   private int F;
   private int G;
   private int H;
   public Vector f = new Vector();
   public static int[][] g = new int[][]{{0, 13}, {13, 11}, {24, 11}, {35, 11}, {46, 11}, {57, 13}, {70, 8}};
   private int I;
   private int J;
   private int K;
   public int h;
   public UIAction i = new UIAction(TextConstant.select(), null);
   private UIAction L = new UIAction("", null);
   public UIAction j = new UIAction(TextConstant.mark(), null);
   private boolean M = false;
   public thien_s k;
   public Vector l;
   public String[] m = new String[]{TextConstant.pleaseWait()};
   public boolean n;
   private thien_u N;
   private UIAction O;
   private int P;
   private int Q;
   private int R;
   private int S;
   private int T;
   private int U;
   private int V;
   private int W;
   private int X;
   private boolean Y;
   private int Z;
   private int aa;

   public static void a() {
      a = new Image[5];
      b = new Image[4];

      try {
         for (int var0 = 0; var0 < 5; var0++) {
            a[var0] = Image.createImage("/Stat" + var0 + ".png");
         }

         for (int var2 = 0; var2 < 4; var2++) {
            b[var2] = Image.createImage("/Nav" + var2 + ".png");
         }
      } catch (IOException var1) {
      }
   }

   public final void a(boolean var1) {
      this.M = var1;
   }

   public final thien_s b() {
      return this.k;
   }

   public final void a(thien_s var1, int var2) {
      this.k = var1;
      this.h = -1;
      this.c();
      this.handleFocus();
   }

   public thien_b(int var1, int var2, int var3, int var4, boolean var5) {
      super(1, 1, var3, var4, true);
      System.currentTimeMillis();
      super.isEnabled = true;
      this.c = true;
      this.I = thien_w.f + 3;
      if (this.I < a[0].getHeight()) {
         this.I = a[0].getHeight();
      }

      this.P = var3 - 51;
      this.Q = 1;
      this.R = 50;
      this.S = 120;
      this.W = var3 / 2;
   }

   public final void c() {
      this.l = new Vector();
      if (this.k != null && this.k.a != null && this.k.a.size() != 0) {
         Vector var1 = this.k.a;
         boolean var2 = false;
         int var3 = var1.size();
         int var4 = 0;

         for (int var5 = 0; var5 < var3; var5++) {
            thien_t var10 = (thien_t)var1.elementAt(var5);
            thien_u var6;
            (var6 = new thien_u()).a = 1;
            var6.g = var10.b();
            var6.d = var10.a();
            this.l.addElement(var6);
            if (var6.g != 1) {
               Vector var12 = var10.a;
               var4 = var10.a.size();

               for (int var7 = 0; var7 < var4; var7++) {
                  thien_r var8 = (thien_r)var12.elementAt(var7);
                  thien_u var9;
                  (var9 = new thien_u()).j = var8.f;
                  var9.d = var8.a;
                  var9.g = var8.c;
                  var9.e = var8.b;
                  var9.b = var8.a();
                  var9.c = var8.j;
                  var9.c = new Integer(var8.a());
                  if (!this.d || var9.g != 0 && var9.g != 0) {
                     if (this.C) {
                        if (var9.d.indexOf(this.B) == -1 && var9.e.indexOf(this.B) == -1) {
                           continue;
                        }

                        if (!var2) {
                           this.h = this.l.size();
                           var2 = true;
                        }
                     }

                     var9.h = var8.e;
                     var9.f = var8.d;
                     var9.i = var8;
                     this.l.addElement(var9);
                  }
               }
            }
         }

         if (this.h < 0) {
            this.h = 0;
         }

         if (this.h >= this.l.size()) {
            this.h = this.l.size() - 1;
         }

         this.K = super.height / this.I + 1;
         this.H = this.l.size() * this.I - super.height + 3 + this.I;
         this.D = this.h * this.I - (super.height >> 1);
         this.J = this.h - (this.K >> 1);
         if (this.l.size() - this.h < this.K >> 1) {
            this.J = this.l.size() - this.K;
         }

         if (this.J < 0) {
            this.J = 0;
         }

         if (((thien_u)this.l.elementAt(this.h)).a == 1) {
            super.actionTertiary = this.L;
         } else if (this.M) {
            super.actionTertiary = this.j;
         } else {
            super.actionTertiary = this.i;
         }
      } else {
         this.J = 0;
         this.K = 0;
         this.H = 0;
      }
   }

   public final boolean handleSoftKey(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.handleKeyInput(var1);
         return false;
      }
   }

   public final boolean handleKeyInput(int var1) {
      if (this.e) {
         return true;
      } else if (this.l != null && this.l.size() != 0) {
         if (var1 == 12) {
            System.currentTimeMillis();
            this.h--;
            if (this.h < 0) {
               this.h = this.l.size() - 1;
            }
         }

         if (var1 == 13) {
            System.currentTimeMillis();
            this.h++;
            if (this.h >= this.l.size()) {
               this.h = 0;
            }
         }

         if (var1 == 12 || var1 == 13) {
            if (((thien_u)this.l.elementAt(this.h)).a == 1) {
               super.actionTertiary = this.L;
            } else if (this.M) {
               super.actionTertiary = this.j;
            } else {
               super.actionTertiary = this.i;
            }

            this.D = this.h * this.I - (super.height >> 1);
            this.J = this.h - (this.K >> 1);
            if (this.l.size() - this.h < this.K >> 1) {
               this.J = this.l.size() - this.K;
            }

            if (this.J < 0) {
               this.J = 0;
            }

            GameCanvas.resetKeys();
            if (thien_ar.a) {
               thien_ar.a(true);
            }
         }

         if (var1 == 16) {
            this.k();
            GameCanvas.resetKeys();
         }

         return true;
      } else {
         return true;
      }
   }

   public static void d() {
   }

   private void k() {
      if (this.h != -1) {
         this.N = (thien_u)this.l.elementAt(this.h);
         if (this.N.a == 0) {
            if (this.N.g == 8) {
               if (this.N.d.startsWith("http://")) {
                  try {
                     Xuka.instance.platformRequest(this.N.d);
                     return;
                  } catch (ConnectionNotFoundException var2) {
                     return;
                  }
               }
            } else if (this.N.g == 4) {
               return;
            }

            if (this.M) {
               thien_u thien_u2 = (thien_u)this.l.elementAt(this.h);
               ((thien_u)this.l.elementAt(this.h)).h = !thien_u2.h;
               thien_u2.i.e = !thien_u2.i.e;
               return;
            }

            if (this.O == null) {
               this.O = new UIAction("Chat", new thien_c(this));
            }

            if (this.c) {
               this.O.actionHandler.action();
               return;
            }
         } else {
            if (this.N.g == 0) {
               this.k.a(this.N.d, 1);
            } else {
               this.k.a(this.N.d, 0);
            }

            this.c();
         }
      }
   }

   public final void draw(Graphics var1) {
      this.T = super.width >> 1;
      var1.setClip(super.baseX, super.baseY, super.width + 1, super.height);
      if (this.e) {
         var1.setColor(16777215);
         thien_w.a(thien_w.d).a(TextConstant.pleaseWait(), this.T, 20, 2, var1, thien_w.j, thien_w.f);
         GameManager.instance.a(var1, this.T, thien_w.f + 35);
      } else if (this.K == 0) {
         var1.setColor(16777215);
         int var9 = this.m.length;

         while (--var9 >= 0) {
            thien_w.a(thien_w.d).a(this.m[var9], this.T, 20 + var9 * thien_w.f, 2, var1, thien_w.j, thien_w.f);
         }
      } else {
         var1.translate(2, 2);
         var1.translate(0, -this.G);
         int var2 = this.J * this.I;
         this.T = this.J + this.K;
         this.U = this.l.size();
         this.V = this.I + 2;
         int var3 = 0;
         int var4 = super.width - 3;

         for (int var5 = this.J; var5 <= this.T && var5 < this.U; var5++) {
            thien_u var6 = (thien_u)this.l.elementAt(var5);
            var3 = this.I;
            if (var5 == this.h) {
               if (var6.a == 0) {
                  var3 <<= 1;
               }

               var1.setColor(2580);
               var1.fillRect(1, var2 + 1, var4, var3);
               var1.setColor(9478569);
               var1.drawRoundRect(0, var2 + 1, var4 + 1, var3, 5, 5);
               if (var3 > this.I) {
                  var1.setColor(3981823);
                  thien_w.a(thien_w.e).a(var6.d, 22, var2 + this.V, var1);
               }
            }

            var1.setColor(0);
            byte var7;
            if (var6.a == 1) {
               var7 = 18;
               var1.drawImage(b[var6.g], 9, var2 + (this.I >> 1) + 1, 3);
            } else {
               var7 = 23;
               int var8 = var6.g == 1 ? 1 : 0;
               var1.drawImage(a[var8], 11, var2 + (this.I >> 1) + 3, 3);
            }

            String var11 = var6.d;
            if (var6.a == 1) {
               var11 = thien_w.a(var11, super.width - 26, thien_w.j);
               var1.setColor(16726823);
               thien_w.a(thien_w.b).a(var11, var7, var2 + 2, var1);
            } else {
               var11 = var6.e;
               if (var6.f != null && !var6.f.equals("")) {
                  var11 = var11 + " - " + var6.f;
               }

               if (!var6.e.equals("")) {
                  var11 = thien_w.a(var11, super.width - 26, thien_w.j);
               }

               var1.setColor(var6.b);
               thien_w.a(var6.c).a(var11, var7, var2 + 3, var1);
               if (this.M && var6.g != 3) {
                  var1.drawImage(GameManager.y[var6.h ? 1 : 0], super.width - 12, var2 + (this.I >> 1), 3);
               }
            }

            var2 += var3;
         }

         var1.translate(0, this.G);
         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         var1.setClip(-1000, -1000, 2000, 2000);
      }
   }

   public final void drawBackground(Graphics var1) {
   }

   public final void update() {
      this.X++;
      if (this.X > 1000) {
         this.X = 0;
      }

      if (this.G != this.D) {
         this.E = this.D - this.G << 2;
         this.F = this.F + this.E;
         this.G = this.G + (this.F >> 4);
         this.F &= 15;
         if (this.G > this.H) {
            this.G = this.H;
         }

         if (this.G < 0) {
            this.G = 0;
         }

         this.J = this.G / this.I - 1;
         if (this.J < 0) {
            this.J = 0;
         }
      }
   }

   public final void handleFocus() {
      if (this.l != null) {
         if (super.baseY + this.l.size() * this.I >= super.height) {
            thien_ar.a = true;
            thien_ar.a(this.l.size());
         } else {
            thien_ar.a = false;
         }
      }
   }

   public final void drawScrollbar(Graphics var1) {
      if (thien_ar.a) {
         thien_ar.a(var1, this.h);
      }
   }

   public final void onDrag(int var1, int var2) {
      this.Z = var1;
      this.aa = var2;
   }

   public final void handleKeyPress(int var1, int var2) {
      if (this.Y) {
         this.Y = false;
         this.D = this.D - (var2 - this.aa) * 5;
         if (this.D < 0) {
            this.D = 0;
         } else if (this.D > this.H) {
            this.D = this.H;
         }
      } else {
         if (this.l == null) {
            return;
         }

         if ((var1 = (var2 + this.G) / this.I) < 0) {
            var1 = 0;
         }

         if (var1 > this.l.size() - 1) {
            var1 = this.l.size() - 1;
         }

         if (var1 < 0) {
            return;
         }

         if (this.h == var1) {
            this.k();
            return;
         }

         if (this.h > var1) {
            this.h = var1;
         } else {
            thien_u var4;
            if ((var4 = (thien_u)this.l.elementAt(this.h)).e != null && !var4.e.equals("")) {
               if (this.h == var1 - 1) {
                  this.k();
                  return;
               }

               this.h = var1 - 1;
            } else {
               this.h = var1;
            }
         }
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public final void handlePointerRelease(int var1, int var2) {
      if (c(var1 - this.Z) > 1 || c(var2 - this.aa) > 1) {
         this.Y = true;
         this.D = this.D - (var2 - this.aa);
         if (this.D < 0) {
            this.D = 0;
         } else if (this.D > this.H) {
            this.D = this.H;
         }

         this.G = this.D;
         this.J = this.G / this.I - 1;
         if (this.J < 0) {
            this.J = 0;
         }

         this.Z = var1;
         this.aa = var2;
      }

      if (thien_ar.a) {
         thien_ar.a(true);
      }
   }

   public static int c(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public final boolean a(String var1, int var2) {
      if (this.k == null) {
         return false;
      } else {
         int var5 = var2;
         String var4 = var1;
         thien_s var3 = this.k;

         for (int var6 = this.k.a.size() - 1; var6 >= 0; var6--) {
            thien_r var7;
            if ((var7 = ((thien_t)var3.a.elementAt(var6)).a(var4)) != null) {
               var7.c = var5;
            }
         }

         if (this.l == null) {
            return false;
         } else {
            if (this.d) {
               this.c();
            } else {
               int var10 = this.l.size();

               while (--var10 >= 0) {
                  thien_u var11;
                  if ((var11 = (thien_u)this.l.elementAt(var10)).a == 0 && var11.d.equals(var1)) {
                     if (var11.g == var2) {
                        return false;
                     }

                     var11.g = var2;
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   public final void a(String var1, String var2, int var3) {
      if (this.k != null) {
         String var6 = var2;
         String var5 = var1;
         thien_s var4 = this.k;

         for (int var7 = this.k.a.size() - 1; var7 >= 0; var7--) {
            thien_r var8;
            if ((var8 = ((thien_t)var4.a.elementAt(var7)).a(var5)) != null) {
               var8.d = var6;
            }
         }

         if (this.l != null) {
            if (this.d) {
               this.c();
            } else {
               int var11 = this.l.size();

               while (--var11 >= 0) {
                  thien_u var12;
                  if ((var12 = (thien_u)this.l.elementAt(var11)).a == 0 && var12.d.equals(var1)) {
                     if (var3 == 1) {
                        var12.f = var2;
                     } else if (var3 == 2) {
                        var12.e = var2;
                     }
                  }
               }
            }
         }
      }
   }

   public final String g() {
      for (int var1 = this.h; var1 >= 0; var1--) {
         thien_u var2;
         if ((var2 = (thien_u)this.l.elementAt(var1)).a == 1) {
            return var2.d;
         }
      }

      return "";
   }

   public final thien_u h() {
      return this.h < 0 ? null : (thien_u)this.l.elementAt(this.h);
   }

   public final void a(String var1) {
      String var3 = var1;
      thien_s var2 = this.k;

      for (int var4 = this.k.a.size() - 1; var4 >= 0; var4--) {
         thien_t var5;
         if ((var5 = (thien_t)var2.a.elementAt(var4)).a().equals(var3) && var5.a.size() == 0) {
            var2.a.removeElementAt(var4);
         }
      }

      if (this.d) {
         this.c();
      } else {
         for (int var6 = this.h; var6 >= 0; var6--) {
            thien_u var7;
            if ((var7 = (thien_u)this.l.elementAt(var6)).a == 1 && var7.d.equals(var1)) {
               this.l.removeElementAt(var6);
               if (this.h >= this.l.size()) {
                  this.h = this.l.size() - 1;
               }
            }
         }
      }
   }

   public final void b(String var1) {
      if (this.k != null) {
         String var3 = var1;
         thien_s var2 = this.k;

         label46:
         for (int var4 = this.k.a.size() - 1; var4 >= 0; var4--) {
            thien_t var5;
            for (int var6 = (var5 = (thien_t)var2.a.elementAt(var4)).a.size() - 1; var6 >= 0; var6--) {
               if (((thien_r)var5.a.elementAt(var6)).a.equals(var3)) {
                  var5.a.removeElementAt(var6);
                  break label46;
               }
            }
         }

         if (this.d) {
            this.c();
         } else {
            for (int var7 = this.h; var7 >= 0; var7--) {
               thien_u var8;
               if ((var8 = (thien_u)this.l.elementAt(var7)).a == 0 && var8.d.equals(var1)) {
                  this.l.removeElementAt(var7);
                  if (this.h >= this.l.size()) {
                     this.h = this.l.size() - 1;
                  }
               }
            }
         }
      }
   }

   public final void a(String var1, String var2) {
      String var4 = var1;
      thien_s var3 = this.k;

      for (int var6 = this.k.a.size() - 1; var6 >= 0; var6--) {
         thien_t var7;
         if ((var7 = (thien_t)var3.a.elementAt(var6)).a().equals(var4)) {
            var7.b(var2);
            break;
         }
      }

      for (int var8 = this.l.size() - 1; var8 >= 0; var8--) {
         thien_u var9;
         if ((var9 = (thien_u)this.l.elementAt(var8)).a == 1 && var9.d.equals(var1)) {
            var9.d = var2;
            return;
         }
      }
   }

   public final boolean c(String var1) {
      for (int var2 = this.l.size() - 1; var2 >= 0; var2--) {
         thien_u var3;
         if ((var3 = (thien_u)this.l.elementAt(var2)).a == 1 && var3.d.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final void d(String var1) {
      if (var1.equals("")) {
         this.C = false;
      } else {
         this.C = true;
         this.B = var1;
         this.d = false;
      }

      this.c();
   }

   public final String[] i() {
      int var1;
      String[] var2 = new String[var1 = this.k.a.size()];

      for (int var3 = 0; var3 < var1; var3++) {
         var2[var3] = ((thien_t)this.k.a.elementAt(var3)).a();
      }

      return var2;
   }

   public final void b(String var1, String var2) {
      var2 = var1;
      thien_s var9 = this.k;
      thien_r var4 = null;

      for (int var5 = var9.a.size() - 1; var5 >= 0; var5--) {
         thien_t var6;
         for (int var7 = (var6 = (thien_t)var9.a.elementAt(var5)).a.size() - 1; var7 >= 0; var7--) {
            thien_r var8;
            if ((var8 = (thien_r)var6.a.elementAt(var7)).a.equals(var2)) {
               var4 = var8;
               var6.a.removeElementAt(var7);
               break;
            }
         }
      }

      if (var4 != null) {
         var9.a(var2, var4);
      }

      this.c();
   }

   public final thien_u e(String var1) {
      for (int var2 = this.l.size() - 1; var2 >= 0; var2--) {
         thien_u var3;
         if ((var3 = (thien_u)this.l.elementAt(var2)).a == 0 && var3.d.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   static thien_u a(thien_b var0) {
      return var0.N;
   }
}
