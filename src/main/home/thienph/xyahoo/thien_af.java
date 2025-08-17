package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class thien_af
extends thien_ac {
    public Image[] a;
    private int[] e;
    private int[] f;
    private Vector g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    public int b = 0;
    public int c = 0;
    private int B = 0;
    public int d = 0;
    private int C = 0;
    private int D;
    private int E;
    private boolean F;
    private int G;
    private int H = 0;
    private int I;

    public thien_af(int n, int n2, int n3, int n4, int n5, String[] stringArray, int[] nArray, int[] nArray2, int n6, int n7, boolean bl, int n8) {
        this.q = 0;
        this.r = n2;
        this.s = n3;
        this.t = n4;
        this.p = true;
        this.j = n5;
        this.g = new Vector();
        n = 0;
        n2 = stringArray.length;
        while (n < n2) {
            String[] stringArray2 = thien_w.a(stringArray[n], '-');
            this.g.addElement(stringArray2);
            ++n;
        }
        this.f = nArray;
        this.e = nArray2;
        this.D = n6;
        this.E = n7;
        this.F = bl;
        this.A = true;
        this.G = 1;
        thien_af thien_af2 = this;
        this.d = thien_af2.s / (thien_af2.D + 25);
        thien_af2.C = thien_af2.j % thien_af2.d == 0 ? thien_af2.j / thien_af2.d : thien_af2.j / thien_af2.d + 1;
        thien_af2.h = (thien_af2.s - thien_af2.d * thien_af2.D) / (thien_af2.d + 1);
        if (thien_af2.G == 1) {
            thien_af2.i = 32;
        } else if (thien_af2.G == 2) {
            thien_af2.i = 32;
        }
        thien_af2.m = thien_af2.i + thien_af2.E + 6;
        thien_af2.k = (thien_af2.s - thien_af2.d * (thien_af2.D + thien_af2.h) >> 1) + (thien_af2.h >> 1);
        thien_af2.l = thien_af2.r;
        n2 = thien_af2.l + thien_af2.C * thien_af2.m - thien_af2.t;
        thien_af2.n = thien_af2.m - n2 % thien_af2.m < 28 ? n2 / thien_af2.m + 1 : n2 / thien_af2.m;
        thien_af2.B = 0;
        thien_af2.b = 0;
        thien_af2.c = 0;
    }

    private boolean d(int n, int n2) {
        return n == this.c && n2 == this.b;
    }

    private boolean e(int n, int n2) {
        return n * this.d + n2 <= this.j - 1;
    }

    public final int a() {
        return this.f[this.c * this.d + this.b];
    }

    private void a(Graphics graphics, Image image, int n, int n2, boolean bl, int n3) {
        int n4 = this.D - image.getWidth() >> 1;
        if (bl) {
            String[] stringArray = (String[])this.g.elementAt(n3);
            thien_v.a(graphics, n - 10, n2 - 6, this.D + 20, this.E + 24 + (stringArray.length > 1 ? thien_w.f - 3 : 0), 8);
        }
        graphics.drawImage(image, n + n4, n2, 20);
    }

    public final boolean a(int n) {
        if (n == 13 || n == 12 || n == 14 || n == 15) {
            this.b(n);
            return false;
        }
        return true;
    }

    public final boolean b(int n) {
        int n2 = 1;
        switch (n) {
            case 14: {
                if (this.b <= 0) break;
                --this.b;
                n2 = 0;
                break;
            }
            case 15: {
                if (this.b >= this.d - 1 || !this.e(this.c, this.b + 1)) break;
                ++this.b;
                n2 = 0;
                break;
            }
            case 12: {
                if (this.c > 0) {
                    --this.c;
                    if (this.B < 0) {
                        this.B += this.m;
                    }
                } else {
                    this.c = this.C - 1;
                    n = this.n;
                    if (!this.e(this.c, this.b)) {
                        --this.c;
                        --n;
                    }
                    if (this.l + this.c * this.m > thien_an.f - thien_an.b - 30) {
                        this.B -= n * this.m;
                    }
                }
                this.b();
                n2 = 0;
                if (!thien_ar.a) break;
                thien_ar.a(true);
                break;
            }
            case 13: {
                n = this.b;
                while (n >= 0) {
                    if (this.c == this.C - 1) {
                        this.c = 0;
                        this.B = 0;
                        break;
                    }
                    if (this.e(this.c + 1, n)) {
                        ++this.c;
                        this.b = n;
                        n = thien_an.f - thien_an.b - 30;
                        n2 = this.C * this.m;
                        if (this.l + this.c * this.m <= n || n2 + this.B <= n) break;
                        this.B -= this.m;
                        break;
                    }
                    --n;
                }
                this.b();
                n2 = 0;
                if (!thien_ar.a) break;
                thien_ar.a(true);
            }
        }
        return n2 != 0;
    }

    private void b() {
        this.H = 0;
        if (this.c == 0) {
            return;
        }
        int n = (this.c + 1) * this.m + this.B + 5;
        if (this.t - n > 20 && this.c == this.C - 1 && this.B < 0) {
            this.H = 30;
            return;
        }
        if (this.t - n < 0) {
            this.H = this.t - n;
        }
    }

    public final void a(Graphics var1) {
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());

      try {
         Graphics var2 = var1;
         thien_af var15 = this;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         for (int var7 = 0; var7 < var15.j; var7++) {
            var5 = var7 / var15.d;
            var6 = var7 % var15.d;
            var3 = var15.k + var6 * (var15.D + var15.h);
            var4 = var15.l + var5 * var15.m + var15.B + var15.H + 5;
            boolean var19 = var15.d(var5, var6);
            if (var4 + var15.E + 10 > var15.r && var4 < thien_an.f) {
               if (var15.F) {
                  var15.a(var2, var15.a[var7], var3, var4, var19, var7);
               } else {
                  var15.a(var2, thien_ck.a(var15.e[var7]), var3, var4, var19, var7);
               }

               String[] var20 = (String[])var15.g.elementAt(var7);
               var6 = 0;

               for (int var8 = var20.length; var6 < var8; var6++) {
                  String var10002 = var20[var6];
                  int var10003 = var3 - 1;
                  int var13 = var4 + var15.E + 1;
                  int var12 = var10003;
                  String var11 = var10002;
                  var2.setColor(16777215);
                  thien_w.a(thien_w.d).a(var11, var12 + (var15.D - thien_w.a(var11, thien_w.j) >> 1), var13, var2);
                  var4 += thien_w.f - 2;
               }
            }
         }
      } catch (Exception var14) {
      }
   }

    public final void f() {
        if (this.l + this.C * this.m > thien_an.f) {
            thien_ar.a = true;
            thien_ar.a(this.C);
            return;
        }
        thien_ar.a = false;
    }

    public final void c(Graphics graphics) {
        if (thien_ar.a) {
            thien_ar.a(graphics, this.c);
        }
    }

    public final void a(int n, int n2) {
        this.I = n2;
    }

    public final void b(int n, int n2) {
        n2 += thien_an.d;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < this.j) {
            n5 = n7 / this.d;
            n6 = n7 % this.d;
            n3 = this.k + n6 * (this.D + this.h);
            n4 = this.l + n5 * this.m + this.B + 5;
            if (n > n3 - 4 && n < n3 + this.D + 4 && n2 > n4 + 14 && n2 < n4 + this.E + 28) {
                if (this.d(n5, n6)) {
                    this.y.b.a();
                    break;
                }
                this.c = n5;
                this.b = n6;
                break;
            }
            ++n7;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void c(int n, int n2) {
        n = n2 - this.I;
        if (thien_b.c(n) > 10) {
            if (n > 0) {
                this.B += n;
                if (this.B > 0) {
                    this.B = 0;
                }
            } else {
                this.B += n;
                if (this.B < -this.n * this.m) {
                    this.B = -this.n * this.m;
                }
            }
            this.I = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void e() {
    }
}
