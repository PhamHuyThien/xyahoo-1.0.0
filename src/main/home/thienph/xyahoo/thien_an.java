package home.thienph.xyahoo;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public class thien_an {
    public boolean a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public String g;
    public String h = "";
    public String i = "";
    public Vector j = new Vector();
    public thien_ab k;
    public thien_ab l;
    public thien_ab m;
    private int w = -1;
    public boolean n;
    public int o;
    private int x;
    public boolean p;
    public int q;
    public int r;
    private int y;
    private int z;
    public int s;
    public boolean t = false;
    private int A;
    public boolean u = false;
    private String B = "";
    private String C = "";
    private String D = "";
    private String E = "";
    public static int v;
    private static int F;
    private boolean G;
    private int H;
    private int I;

    static {
        F = 0;
    }

    public final void a(int n) {
        this.n = true;
        if (n == -1) {
            this.o = e;
            this.x = -e >> 2;
            return;
        }
        this.o = -e;
        this.x = e >> 2;
    }

    public final void b(int n) {
        this.i = thien_w.a(this.g, n, thien_w.j);
    }

    public final void a(String string) {
        this.i = thien_w.a(string, thien_d.j - 30, thien_w.j);
    }

    public void a(Graphics graphics) {
        this.b(graphics);
        Graphics graphics2 = graphics;
        thien_an thien_an2 = this;
        int n = 0;
        while (n < thien_an2.A) {
            graphics2.setClip(0, d, e, f - b);
            graphics2.translate(0, -thien_an2.r);
            graphics2.translate(0, d);
            thien_ac thien_ac2 = (thien_ac)thien_an2.j.elementAt(n);
            if (thien_ac2.r - thien_an2.r + thien_ac2.t > 0 && thien_ac2.r - thien_an2.r < f - b - 10) {
                thien_ac2.a(graphics2);
            }
            if (n == thien_an2.w) {
                thien_ac2.b(graphics2);
            }
            graphics2.translate(0, -d);
            graphics2.translate(0, thien_an2.r);
            ++n;
        }
        graphics2.translate(-graphics2.getTranslateX(), -graphics2.getTranslateY());
        graphics.setClip(0, 0, 1000, 1000);
        this.d(graphics);
        graphics2 = graphics;
        thien_an2 = this;
        graphics2.setClip(0, 0, 1000, 1000);
        thien_an.c(graphics2);
        thien_an2.B = thien_an2.E;
        thien_an2.C = thien_an2.E;
        thien_an2.D = thien_an2.E;
        if (thien_an2.k != null) {
            thien_an2.B = thien_an2.k.a;
        }
        if (thien_an2.l != null) {
            thien_an2.C = thien_an2.l.a;
        }
        if (thien_an2.m != null) {
            thien_an2.D = thien_an2.m.a;
        }
        if (thien_an2.w != -1) {
            thien_ac thien_ac3 = (thien_ac)thien_an2.j.elementAt(thien_an2.w);
            if (thien_ac3.w != null) {
                thien_an2.B = thien_ac3.w.a;
            }
            if (thien_ac3.x != null) {
                thien_an2.C = thien_ac3.x.a;
            }
            if (thien_ac3.y != null) {
                thien_an2.D = thien_ac3.y.a;
            }
        }
        graphics2.setColor(0xFFFFFF);
        thien_w.a(thien_w.d).a(thien_an2.B, 4, v, graphics2);
        thien_w.a(thien_w.d).a(thien_an2.C, 0 + e - 4, v, 1, graphics2, thien_w.j, thien_w.f);
        thien_w.a(thien_w.d).a(thien_an2.D, 0 + (e >> 1), v, 2, graphics2, thien_w.j, thien_w.f);
    }

    public void b(Graphics graphics) {
    }

    public void a(thien_ac thien_ac2) {
        if (this.j.contains(thien_ac2)) {
            return;
        }
        thien_ac2.v = this;
        this.j.addElement(thien_ac2);
    }

    public void b(thien_ac thien_ac2) {
        this.j.removeElement(thien_ac2);
        this.A = this.j.size();
    }

    public void a() {
        this.j.removeAllElements();
    }

    public final boolean c(thien_ac thien_ac2) {
        this.A = this.j.size();
        int n = 0;
        while (n < this.A) {
            thien_ac thien_ac3 = (thien_ac)this.j.elementAt(n);
            if (thien_ac2.equals(thien_ac3) && thien_ac2.o) {
                this.w = n;
                this.b();
                return true;
            }
            ++n;
        }
        return false;
    }

    protected final void b() {
        thien_ac thien_ac2 = (thien_ac)this.j.elementAt(this.w);
        int n = thien_ac2.r + d;
        if (n - d < this.q + 20 && this.w != 0) {
            n = this.w - 1;
            while (n >= 0) {
                thien_ac thien_ac3 = (thien_ac)this.j.elementAt(n);
                if (!thien_ac3.o) {
                    thien_ac2 = thien_ac3;
                    break;
                }
                --n;
            }
            n = thien_ac2.r + d;
            this.q = n - d - 15;
            return;
        }
        if (n + thien_ac2.t > this.q + f + 1 && !this.u) {
            this.q = n + thien_ac2.t - f + 15;
            return;
        }
        if (thien_ac2.r < this.r) {
            this.q = thien_ac2.r - 2;
        }
    }

    public final boolean d(thien_ac thien_ac2) {
        try {
            thien_ac thien_ac3 = (thien_ac)this.j.elementAt(this.w);
            if (thien_ac3.equals(thien_ac2)) {
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public final void c() {
        if (this.n) {
            this.o += this.x;
            if (this.o < 10 && this.o > -10) {
                this.n = false;
            }
        }
    }

    public boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      boolean var4 = false;
      this.A = this.j.size();
      if (this.w != -1) {
         if (this.r != this.q) {
            this.z = this.q - this.r << 2;
            this.y = this.y + this.z;
            this.r = this.r + (this.y >> 4);
            this.y &= 15;
         }

         this.r = this.q;
      }

      if (this.w != -1) {
         if (var3[0] > 0) {
            ((thien_ac)this.j.elementAt(this.w)).b(var3[0]);
            var3[0] = 0;

            for (int var8 = 0; var8 < var1.length; var8++) {
               var1[var8] = false;
            }

            return false;
         }

         for (int var6 = 0; var6 < 21; var6++) {
            if (var2[var6] && ++F > 4) {
               if (((thien_ac)this.j.elementAt(this.w)).a(var6)) {
                  if (var6 == 12) {
                     int var15 = this.w;

                     do {
                        if (--var15 == -1) {
                           var15 = this.A - 1;
                        }
                     } while (!((thien_ac)this.j.elementAt(var15)).o);

                     this.w = var15;
                  } else if (var6 == 13) {
                     int var14 = this.w;

                     do {
                        if (++var14 == this.A) {
                           var14 = 0;
                        }
                     } while (!((thien_ac)this.j.elementAt(var14)).o);

                     this.w = var14;
                  }

                  this.b();
                  var2[var6] = false;
                  if (thien_ar.a) {
                     thien_ar.a(true);
                  }
               }

               F = 4;
            } else if (var1[var6]) {
               if (((thien_ac)this.j.elementAt(this.w)).b(var6)) {
                  if (var6 == 12) {
                     int var13 = this.w;

                     do {
                        if (--var13 == -1) {
                           var13 = this.A - 1;
                        }
                     } while (!((thien_ac)this.j.elementAt(var13)).o);

                     this.w = var13;
                     this.b();
                     if (thien_ar.a) {
                        thien_ar.a(true);
                     }
                  } else if (var6 == 13) {
                     int var12 = this.w;

                     do {
                        if (++var12 == this.A) {
                           var12 = 0;
                        }
                     } while (!((thien_ac)this.j.elementAt(var12)).o);

                     this.w = var12;
                     this.b();
                     if (thien_ar.a) {
                        thien_ar.a(true);
                     }
                  } else {
                     thien_ae var5 = null;
                     if (var6 == 17) {
                        if (this.k != null) {
                           var5 = this.k.b;
                        }

                        thien_ac var9;
                        if (this.w != -1 && (var9 = (thien_ac)this.j.elementAt(this.w)).w != null) {
                           var5 = var9.w.b;
                        }
                     } else if (var6 == 18) {
                        if (this.l != null) {
                           var5 = this.l.b;
                        }

                        thien_ac var10;
                        if (this.w != -1 && (var10 = (thien_ac)this.j.elementAt(this.w)).x != null) {
                           var5 = var10.x.b;
                        }
                     } else if (var6 == 16) {
                        if (this.m != null) {
                           var5 = this.m.b;
                        }

                        thien_ac var11;
                        if (this.w != -1 && (var11 = (thien_ac)this.j.elementAt(this.w)).y != null) {
                           var5 = var11.y.b;
                        }
                     }

                     if (var5 != null) {
                        var5.a();
                     }
                  }

                  var4 = true;
               } else {
                  var4 = false;
               }

               var1[var6] = false;
            }
         }
      }

      int var7 = this.A;

      while (--var7 >= 0) {
         ((thien_ac)this.j.elementAt(var7)).e();
      }

      return var4;
   }

    public final void a(int n, int n2) {
        if (this.G && !this.p) {
            this.G = false;
            this.q -= (n2 - this.H) * 5;
        }
        int n3 = this.j.size();
        block0: while (--n3 >= 0) {
            thien_ac thien_ac2 = (thien_ac)this.j.elementAt(n3);
            int n4 = 0;
            int n5 = 0;
            while (n5 < 2) {
                if (n > thien_ac2.q && n2 + this.r + n4 > thien_ac2.r && n < thien_ac2.q + thien_ac2.s && n2 + this.r + n4 < thien_ac2.r + thien_ac2.t) {
                    thien_ac2.b(n - thien_ac2.q, n2 + this.r - thien_ac2.r);
                    return;
                }
                if (!(thien_ac2 instanceof thien_at)) continue block0;
                n4 -= thien_ac2.t;
                ++n5;
            }
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void b(int n, int n2) {
        int n3 = this.j.size();
        while (--n3 >= 0) {
            thien_ac thien_ac2 = (thien_ac)this.j.elementAt(n3);
            if (n <= thien_ac2.q || n2 + this.r <= thien_ac2.r || n >= thien_ac2.q + thien_ac2.s || n2 + this.r >= thien_ac2.r + thien_ac2.t || !thien_ac2.p) continue;
            thien_ac2.c(n - thien_ac2.q, n2 + this.r - thien_ac2.r);
            return;
        }
        if (!this.p && thien_b.c(n2 - this.H) > 1) {
            this.G = true;
            this.q -= n2 - this.H;
            if (this.q < 0) {
                this.q = 0;
            } else if (this.q > this.I) {
                this.q = this.I;
            }
            this.r = this.q;
            this.H = n2;
        }
        if (thien_ar.a) {
            thien_ar.a(true);
        }
    }

    public final void c(int n, int n2) {
        int n3 = this.j.size();
        while (--n3 >= 0) {
            thien_ac thien_ac2 = (thien_ac)this.j.elementAt(n3);
            if (n <= thien_ac2.q || n2 + this.r <= thien_ac2.r || n >= thien_ac2.q + thien_ac2.s || n2 + this.r >= thien_ac2.r + thien_ac2.t || !thien_ac2.p) continue;
            thien_ac2.a(n - thien_ac2.q, n2 + this.r - thien_ac2.r);
            return;
        }
        if (!this.p) {
            this.H = n2;
        }
    }

    public final void d(int n, int n2) {
        if (!this.p) {
            this.H = n2;
        }
    }

    public static void c(Graphics graphics) {
        if (thien_w.a) {
            graphics.drawImage(thien_di.v, 0, f + 2, 20);
            return;
        }
        int n = f + 3;
        int n2 = b >> 1;
        graphics.setColor(1404853);
        graphics.fillRect(0, n, e, n2);
        graphics.setColor(1334695);
        graphics.fillRect(0, n + n2, e, ++n2);
        graphics.setColor(672643);
        graphics.fillRect(0, n, e, 1);
        graphics.setColor(6796786);
        graphics.fillRect(0, ++n, e, 1);
    }

    public thien_ac c(int n) {
        int n2 = this.j.size();
        while (--n2 >= 0) {
            thien_ac thien_ac2 = (thien_ac)this.j.elementAt(n2);
            if (thien_ac2.u != n) continue;
            return thien_ac2;
        }
        return null;
    }

    public void d() {
        this.A = this.j.size();
        if (this.A == 1 && ((thien_ac)this.j.elementAt((int)0)).A) {
            ((thien_ac)this.j.elementAt(0)).f();
            return;
        }
        int n = d;
        int n2 = 0;
        int n3 = this.A;
        while (n2 < n3) {
            n += ((thien_ac)this.j.elementAt((int)n2)).t + 2;
            ++n2;
        }
        if (n >= f) {
            thien_ar.a = true;
            thien_ar.a(this.A);
            this.I = n - f;
            return;
        }
        thien_ar.a = false;
    }

    public void d(Graphics graphics) {
        if (this.A == 1 && ((thien_ac)this.j.elementAt((int)0)).A) {
            ((thien_ac)this.j.elementAt(0)).c(graphics);
            return;
        }
        if (thien_ar.a) {
            thien_ar.a(graphics, this.w);
        }
    }
}
