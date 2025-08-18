package home.thienph.xyahoo;

import javax.microedition.lcdui.Graphics;

public final class thien_ax extends thien_ac
{
    private static int C;
    private static int D;
    private static thien_by[] E;
    private static thien_by[] F;
    private static String[] G;
    private byte[] H;
    private byte[] I;
    private int J;
    private int K;
    public String a;
    public String b;
    private static int L;
    public int c;
    public thien_by[] d;
    private thien_by[] M;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public String k;
    public static boolean l;
    private boolean N;
    private int O;
    private int P;
    private long Q;
    private long R;
    private static int S;
    private static int T;
    private static boolean U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    public thien_by[] m;
    public boolean n;
    public static boolean B;
    private thien_by[][] ab;
    private int ac;
    private int ad;
    
    static {
        thien_ax.B = false;
    }
    
    public thien_ax(final byte[] h) {
        thien_by.a();
        this.K = thien_an.f - 60;
        if (thien_an.e > 130) {
            thien_ax.S = thien_an.e - thien_by.a - (thien_by.a >> 2) * 12 >> 1;
        }
        else {
            thien_ax.S = 0;
        }
        thien_ax.T = 70;
        thien_ax.G = null;
        thien_ax.F = null;
        thien_ax.E = null;
        this.d = null;
        this.M = null;
        System.gc();
        thien_ax.G = new String[4];
        thien_ax.C = 0;
        this.H = h;
        thien_ax.U = true;
        this.n = false;
        thien_ax.F = new thien_by[thien_ax.D = this.H.length];
        thien_ax.E = new thien_by[thien_ax.C];
        this.d = new thien_by[thien_ax.C];
        this.M = new thien_by[3];
        for (int i = 0; i < this.M.length; ++i) {
            (this.M[i] = new thien_by()).b((thien_an.e >> 1) - 30 + i * 10, thien_an.f - 130 >> 1);
        }
        for (int j = 0; j < thien_ax.C; ++j) {
            this.d[j] = new thien_by();
        }
        for (byte b = 0; b < thien_ba.S.K; ++b) {
            thien_ax.G[b] = thien_ba.S.A[b];
        }
        for (int k = 0; k < thien_ax.D; ++k) {
            thien_ax.F[k] = new thien_by();
            thien_ax.F[k].c = this.H[k];
            thien_ax.F[k].d = (byte)(this.H[k] >> 2);
            thien_ax.F[k].e = (byte)(this.H[k] % 4);
            thien_ax.F[k].b(50 + k * 14, thien_an.f - 100);
            if (k == thien_ax.D - 1) {
                thien_ax.F[k].f = true;
            }
        }
        this.J = 0;
        c();
        this.O = 0;
        this.P = 0;
        this.Q = 10L;
        this.R = System.currentTimeMillis();
        super.q = 0;
        super.r = 0;
        super.s = thien_an.e;
        super.t = thien_an.f;
        super.p = true;
    }
    
    public final void b(final int n, final int n2) {
        if (!thien_ax.B && thien_ax.D > 0) {
            int i = 0;
            while (true) {
                while (i < thien_ax.D) {
                    final int j = thien_ax.F[i].i;
                    final int k = thien_ax.F[i].j;
                    if (n > j && n < j + 11 && n2 > k && n2 < k + thien_by.b) {
                        final int n4;
                        final int n3 = n4 = i;
                        final int l = n4;
                        if (n3 == -1) {
                            return;
                        }
                        this.J = l;
                        if (!thien_ax.F[this.J].g) {
                            this.b(12);
                        }
                        else {
                            this.b(13);
                        }
                        final int a = thien_w.a(thien_ba.S.m.a, thien_w.j);
                        final int n5 = (super.s >> 1) - (a >> 1);
                        final int t = super.t;
                        if (n > n5 && n < n5 + a && n2 > t && n2 < t + thien_an.b) {
                            this.b(16);
                        }
                        return;
                    }
                    else {
                        ++i;
                    }
                }
                int n4;
                final int n3 = n4 = -1;
                continue;
            }
        }
    }
    
    public final boolean b(int i) {
        if (thien_ax.l) {
            return false;
        }
        boolean b = true;
        Label_1049: {
            switch (i) {
                case 12: {
                    if (!thien_ax.B && thien_ax.D > 0 && !thien_ax.F[this.J].g) {
                        thien_ax.F[this.J].g = true;
                        final thien_by thien_by = thien_ax.F[this.J];
                        thien_by.j -= 20;
                        thien_ax.F[this.J].f = true;
                        if (this.J > 0) {
                            thien_ax.F[this.J - 1].f = true;
                        }
                    }
                    b = false;
                    break;
                }
                case 13: {
                    if (!thien_ax.B && thien_ax.D > 0 && thien_ax.F[this.J].g) {
                        thien_ax.F[this.J].g = false;
                        final thien_by thien_by2 = thien_ax.F[this.J];
                        thien_by2.j += 20;
                        if (this.J != thien_ax.D - 1) {
                            thien_ax.F[this.J].f = true;
                        }
                        if (this.J > 0) {
                            thien_ax.F[this.J - 1].f = true;
                        }
                        b = false;
                        break;
                    }
                    if (!thien_ba.J) {
                        b = false;
                        break;
                    }
                    break;
                }
                case 14: {
                    --this.J;
                    if (this.J < 0) {
                        this.J = 0;
                        break Label_1049;
                    }
                    b = false;
                    break;
                }
                case 15: {
                    ++this.J;
                    if (this.J > thien_ax.D - 1) {
                        this.J = thien_ax.D - 1;
                        break Label_1049;
                    }
                    b = false;
                    break;
                }
                case 16: {
                    if (!thien_ax.B) {
                        for (i = 0; i < thien_ax.D; ++i) {
                            if (thien_ax.F[i].g) {
                                ++thien_ax.C;
                            }
                        }
                        thien_ax.E = new thien_by[thien_ax.C];
                        this.I = new byte[thien_ax.C];
                        i = 0;
                        for (int j = 0; j < thien_ax.D; ++j) {
                            if (thien_ax.F[j].g) {
                                thien_ax.E[i] = thien_ax.F[j];
                                ++i;
                            }
                        }
                        if (!this.n) {
                            final thien_by[] e = thien_ax.E;
                            int n = 0;
                            final byte[] a = thien_by.a(e);
                            if (!this.g && thien_ba.z.equals(this.b)) {
                                if (this.e && a(e) == a(thien_ax.F)) {
                                    if ((n = (this.a(a, 0) ? 1 : 0)) != 0) {
                                        this.e = false;
                                    }
                                }
                                else if (!this.e && (n = (this.a(a, 0) ? 1 : 0)) != 0 && !this.h) {
                                    final int l = thien_ax.L;
                                    final thien_by[] e2 = thien_ax.E;
                                    final int c = this.c;
                                    final thien_by[] d = this.d;
                                    final boolean b2 = false;
                                    final thien_by[] array = d;
                                    final int n2 = c;
                                    final thien_by[] array2 = e2;
                                    final int n3 = l;
                                    int n4 = 0;
                                    if (n3 == n2) {
                                        if (array2.length == array.length && array2[array2.length - 1].c > array[array.length - 1].c) {
                                            n4 = 1;
                                            if (b2) {
                                                if (n3 == 1 && array2[0].e != array[0].e && array2[0].d != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 2 && array2[0].e != array[0].e && array2[0].d != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 3 && (array2[0].e != array[0].e || array2[1].e != array[1].e || array2[2].e != array[2].e) && array2[0].d != 15) {
                                                    n4 = 0;
                                                }
                                                else if (n3 == 4 && array2[0].e != array[0].e) {
                                                    n4 = 0;
                                                }
                                            }
                                        }
                                    }
                                    else if (array[array.length - 1].d == 15) {
                                        if (array.length == 1 && (n3 == 10 || n3 == 11 || n3 == 12)) {
                                            n4 = 1;
                                        }
                                        else if (array.length == 2 && (n3 == 11 || n3 == 12)) {
                                            n4 = 1;
                                        }
                                    }
                                    else if (n2 == 10 && (n3 == 12 || n3 == 11)) {
                                        n4 = 1;
                                    }
                                    else if (n2 == 11 && n3 == 12) {
                                        n4 = 1;
                                    }
                                    n = n4;
                                }
                            }
                            else {
                                final byte[] array3 = a;
                                final int n5 = 0;
                                final byte[] array4 = array3;
                                boolean b3 = false;
                                if (array4.length == 8 && c(array4, n5)) {
                                    b3 = true;
                                }
                                if (b3) {
                                    if (this.c == 10 || this.c == 11 || ((this.d.length == 1 || this.d.length == 2) && this.d[this.d.length - 1].d == 15)) {
                                        thien_ax.L = 12;
                                        n = 1;
                                    }
                                    else {
                                        n = 0;
                                    }
                                }
                                else {
                                    n = 0;
                                }
                            }
                            if (n != 0) {
                                for (int k = 0; k < thien_ax.C; ++k) {
                                    this.I[k] = thien_ax.E[k].c;
                                }
                                MessageHandler.a(thien_ba.B, thien_ba.z, thien_ax.L, this.I);
                                this.n = true;
                                break Label_1049;
                            }
                        }
                        this.a();
                    }
                    break Label_1049;
                }
                case 17: {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public final void a() {
        for (int i = 0; i < thien_ax.D; ++i) {
            if (thien_ax.F[i].g) {
                thien_ax.F[i].g = false;
            }
        }
        c();
        thien_ax.C = 0;
        if (this.J >= thien_ax.D) {
            this.J = thien_ax.D - 1;
        }
        this.n = false;
    }
    
    public final void a(final byte[] array) {
        int n = 0;
        for (int i = 0; i < thien_ax.D; ++i) {
            for (int j = 0; j < array.length; ++j) {
                if (thien_ax.F[i].c == array[j]) {
                    thien_ax.F[i].g = true;
                    thien_ax.F[i].h = true;
                }
                else {
                    thien_ax.F[i].g = false;
                }
            }
        }
        for (int k = 0; k < thien_ax.D; ++k) {
            if (!thien_ax.F[k].h) {
                thien_ax.F[n] = thien_ax.F[k];
                ++n;
            }
        }
        thien_ax.D -= array.length;
        c();
        for (int l = 0; l < thien_ax.C; ++l) {
            thien_ax.E[l].b((thien_an.e >> 1) - 30 + l * 10, thien_an.f - 130 >> 1);
            if (l == thien_ax.C - 1) {
                thien_ax.E[l].f = true;
            }
        }
        thien_ax.C = 0;
        this.J = 0;
    }
    
    public final void a(final Graphics graphics) {
        graphics.setClip(0, -5, thien_an.e, thien_an.f);
        if (thien_ax.l) {
            final int n = (thien_an.e >> 1) - 50;
            final int n2 = thien_an.f - 140 >> 1;
            thien_by.a(graphics, n, n2);
            if (this.O < thien_ax.D) {
                thien_by.a(graphics, n + (thien_ax.F[this.O].i - n) * (this.P + 1) / 3, n2 + (thien_ax.F[this.O].j - n2) * (this.P + 1) / 3);
            }
            for (int i = 0; i < this.O; ++i) {
                if (!thien_ax.F[i].h && this.O < thien_ax.D) {
                    thien_ax.F[i].a(graphics);
                }
            }
            return;
        }
        if (thien_ax.B) {
            this.ac = this.ab.length;
            for (int j = 0; j < this.ac; ++j) {
                this.ad = this.ab[j].length;
                for (int k = 0; k < this.ad; ++k) {
                    if (this.ab[j][k] != null) {
                        this.ab[j][k].a(graphics);
                    }
                }
            }
        }
        else {
            for (int l = 0; l < thien_ax.D; ++l) {
                if (!thien_ax.F[l].h) {
                    thien_ax.F[l].a(graphics);
                }
            }
        }
        if (thien_ba.S.Q && thien_ax.U) {
            if (this.h) {
                this.ac = this.M.length;
                for (int n3 = 0; n3 < this.ac; ++n3) {
                    if (this.M[n3] != null) {
                        final int n4 = this.M.length - 1;
                        this.M[n3].b(graphics);
                    }
                }
            }
            else {
                try {
                    if (this.m != null) {
                        this.a(graphics, this.m);
                    }
                    if (this.d != null) {
                        this.a(graphics, this.d);
                    }
                }
                catch (final NullPointerException ex) {
                    final Throwable t;
                    ex.printStackTrace();
                }
            }
        }
        if (!thien_ax.B) {
            graphics.drawImage(thien_by.l, thien_ax.S + 2 + this.J * 11, this.K, 0);
        }
        for (int n5 = 0; n5 < thien_ba.S.F.length; ++n5) {
            final thien_bz thien_bz;
            if ((thien_bz = thien_ba.S.F[n5]).m) {
                thien_bz.a(graphics, thien_bz.e, thien_bz.f - 5);
            }
        }
    }
    
    public final void a(final byte[] array, final int z, final int aa) {
        this.N = true;
        this.m = this.d;
        this.ac = array.length;
        this.d = new thien_by[this.ac];
        for (int i = 0; i < this.ac; ++i) {
            this.d[i] = new thien_by();
            this.d[i].c = array[i];
            this.d[i].d = (byte)(array[i] >> 2);
            this.d[i].e = (byte)(array[i] % 4);
            this.d[i].i = (thien_an.e >> 1) - 50 + i * 14;
            this.d[i].j = thien_an.f - 140 >> 1;
            if (i == array.length - 1) {
                this.d[i].f = true;
            }
        }
        this.V = thien_an.e / 3;
        this.W = thien_an.f - 140 >> 1;
        this.X = (this.V - z) / 5;
        this.Y = (this.W - aa) / 5;
        this.Z = z;
        this.aa = aa;
        this.ac = this.d.length;
        for (int j = 0; j < this.ac; ++j) {
            this.d[j].b(z + j * 10, aa);
        }
    }
    
    private void a(final Graphics graphics, final thien_by[] array) {
        try {
            this.ac = array.length;
            for (int i = 0; i < this.ac; ++i) {
                if (array[i] != null) {
                    array[i].a(graphics);
                }
            }
        }
        catch (final NullPointerException ex) {
            final Throwable t;
            ex.printStackTrace();
        }
    }
    
    public final void e() {
        final long currentTimeMillis;
        if (thien_ax.l && (currentTimeMillis = System.currentTimeMillis()) - this.R >= this.Q) {
            this.R = currentTimeMillis;
            this.P = (this.P + 1) % 2;
            if (this.P == 0) {
                ++this.O;
                if (this.O > thien_ax.D) {
                    thien_ax.l = false;
                    this.O = 0;
                }
            }
        }
        if (this.N && !thien_ax.B) {
            final int z = this.Z;
            final int aa = this.aa;
            Label_0155: {
                if (thien_b.c(this.V - this.Z) > thien_b.c(this.X)) {
                    this.Z += this.X;
                    if (this.Z != z) {
                        break Label_0155;
                    }
                }
                this.Z = this.V;
            }
            Label_0206: {
                if (thien_b.c(this.W - this.aa) > thien_b.c(this.Y)) {
                    this.aa += this.Y;
                    if (this.aa != aa) {
                        break Label_0206;
                    }
                }
                this.aa = this.W;
            }
            this.ac = this.d.length;
            for (int i = 0; i < this.ac; ++i) {
                this.d[i].b(this.Z + i * 10, this.aa);
            }
            if (this.Z == this.V && this.aa == this.W) {
                this.m = null;
                this.N = false;
            }
        }
        ++thien_ba.y;
    }
    
    private static void c() {
        for (int i = 0; i < thien_ax.D; ++i) {
            thien_ax.F[i].b(thien_ax.S + i * 11, thien_an.f - thien_ax.T);
        }
    }
    
    public final void b() {
        this.ab = null;
        System.gc();
        this.ab = new thien_by[thien_ba.S.U][];
        thien_ax.B = true;
        this.ac = thien_ba.S.V.length;
        for (byte b = 0; b < thien_ba.S.U; ++b) {
            final String a = thien_ba.S.F[b].a;
            final byte k = thien_ba.S.F[b].k;
            for (int i = 0; i < this.ac; ++i) {
                if (thien_ba.S.V[i].equals(a)) {
                    this.ab[b] = new thien_by[thien_ba.S.W[i].length];
                    int n = 0;
                    int j = 0;
                    if (k == 0) {
                        n = thien_ax.S;
                        j = thien_an.f - thien_ax.T;
                    }
                    else if (k == 1) {
                        n = thien_an.e - this.ab[b].length * 10 - 20;
                        j = (thien_an.f >> 1) - 5;
                    }
                    else if (k == 2) {
                        n = thien_ax.S;
                        j = 0;
                    }
                    else if (k == 3) {
                        n = 0;
                        j = (thien_an.f >> 1) - 15;
                    }
                    this.ad = this.ab[b].length;
                    for (int l = 0; l < this.ad; ++l) {
                        this.ab[b][l] = new thien_by();
                        this.ab[b][l].c = thien_ba.S.W[i][l];
                        this.ab[b][l].d = (byte)(thien_ba.S.W[i][l] >> 2);
                        this.ab[b][l].e = (byte)(thien_ba.S.W[i][l] % 4);
                        this.ab[b][l].i = n + l * 11;
                        this.ab[b][l].j = j;
                        if (l == this.ab[b].length - 1) {
                            this.ab[b][l].f = true;
                        }
                    }
                    break;
                }
            }
        }
        thien_ba.S.f();
    }
    
    private static int a(final thien_by[] array) {
        if (array.length == 0) {
            return 0;
        }
        return array[0].c;
    }
    
    private boolean a(final byte[] array, final int n) {
        boolean b = false;
        if (n == 1) {
            final int[] array2 = new int[thien_ax.D - array.length];
            int n2 = 0;
            for (int i = 0; i < thien_ax.D; ++i) {
                if (!thien_ax.F[i].g) {
                    array2[n2] = thien_ax.F[i].d;
                    ++n2;
                }
            }
            this.ac = array2.length;
            for (int j = 0; j < this.ac; ++j) {
                if (array2[j] != 15) {
                    b = true;
                    break;
                }
            }
            if (array2.length == 0) {
                b = true;
            }
            b = (b && b(array, n));
        }
        else if (n == 0) {
            b = b(array, n);
        }
        return b;
    }
    
    private static boolean b(byte[] var0, int var1) {
      boolean var2;
      if (var0.length == 1) {
         L = 1;
         var2 = true;
      } else if (var0.length == 2) {
         var2 = false;
         byte[] var3;
         if ((var3 = thien_by.a(var0)).length == 2 && var3[0] == var3[1]) {
            var2 = true;
         }

         if (var2 && var1 == 1 && !thien_by.a(var0[0], var0[1]) && var3[0] != 15) {
            var2 = false;
         }

         if (var2 = var2) {
            L = 2;
         }
      } else if (var0.length == 3) {
         if (var2 = d(var0, var1)) {
            L = 4;
         } else {
            byte[] var5;
            if (var2 = (var5 = thien_by.a(var0)).length == 3 && var5[0] == var5[1] && var5[1] == var5[2]) {
               L = 3;
            }
         }
      } else if (var0.length == 4) {
         if (var2 = d(var0, var1)) {
            L = 4;
         } else {
            var2 = false;
            byte[] var7;
            if ((var7 = thien_by.a(var0)).length == 4 && var7[0] == var7[1] && var7[2] == var7[3] && var7[0] == var7[2]) {
               var2 = true;
            }

            if (var2 = var2) {
               L = 11;
            }
         }
      } else if (var0.length == 5) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else if (var0.length == 6) {
         if (var2 = d(var0, var1)) {
            L = 4;
         } else if (var2 = c(var0, var1)) {
            L = 10;
         }
      } else if (var0.length == 7) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else if (var0.length == 8) {
         if (var2 = d(var0, var1)) {
            L = 4;
         } else if (var2 = c(var0, var1)) {
            L = 12;
         }
      } else if (var0.length == 9) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else if (var0.length == 10) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else if (var0.length == 11) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else if (var0.length == 12) {
         if (var2 = d(var0, var1)) {
            L = 4;
         }
      } else {
         var2 = false;
      }

      return var2;
   }
    
    private static boolean c(final byte[] array, final int n) {
        boolean b = false;
        if (array.length % 2 == 0) {
            final int n2;
            final byte[] array2 = new byte[n2 = array.length >> 1];
            final byte[] array3 = new byte[n2];
            for (int i = 0; i < n2; ++i) {
                array2[i] = array[i << 1];
                array3[i] = array[1 + (i << 1)];
            }
            if (d(array2, n) && d(array3, n) && thien_by.a(array2[0]) == thien_by.a(array3[0])) {
                b = true;
                if (n == 1 && !thien_by.a(array2[0], array3[0])) {
                    b = false;
                }
            }
        }
        return b;
    }
    
    private static boolean d(final byte[] array, final int n) {
        boolean b = true;
        final byte[] a;
        if ((a = thien_by.a(array))[a.length - 1] == 15) {
            b = false;
        }
        else {
            for (int i = 0; i < a.length - 1; ++i) {
                if (a[i + 1] - 1 != a[i]) {
                    b = false;
                    break;
                }
            }
        }
        if (n == 1 && b) {
            for (int length = array.length, j = 1; j < length; ++j) {
                if (thien_by.a((int)array[j]) != thien_by.a((int)array[j - 1])) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }
    
    public final boolean a(final int n) {
        return false;
    }
}
